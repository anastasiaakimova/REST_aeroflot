package com.example.demo.controller;

import com.example.demo.entity.Archive;
import com.example.demo.entity.Pilot;
import com.example.demo.entity.Plane;
import com.example.demo.service.ArchiveService;
import com.example.demo.service.GeneralService;
import com.example.demo.service.PilotService;
import com.example.demo.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaneController {

    @Qualifier("pilotServiceImpl")
    @Autowired
    PilotService pilotService;

    @Qualifier("planeServiceImpl")
    @Autowired
    PlaneService planeService;

    @Qualifier("archiveServiceImpl")
    @Autowired
    ArchiveService archiveService;

    @RequestMapping(value = "/pilot/plane/{pName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pilot> getPilotByPlane(@PathVariable("pName") String pName) {
        if (pName == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Plane plane = planeService.findByBrand(pName);

        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Long id = plane.getId();

        Archive archive = archiveService.findByPlane(id);
        Pilot pilot = archive.getPilot();

        return new ResponseEntity<>(pilot, HttpStatus.OK);
    }

    @RequestMapping(value = "/plane/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> getPlane(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Plane plane = planeService.findById(id);

        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(plane, HttpStatus.OK);
    }

    @RequestMapping(value = "/plane", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> addPlane(@RequestBody Plane plane) {
        HttpHeaders headers = new HttpHeaders();
        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        planeService.save(plane);
        return new ResponseEntity<>(plane, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/plane/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plane> deletePlane(@PathVariable("id") Long id) {
        Plane plane = planeService.findById(id);

        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        planeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/plane", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plane>> getAllPlanes() {
        List<Plane> planes = planeService.findAll();

        if (planes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(planes, HttpStatus.OK);
    }
}
