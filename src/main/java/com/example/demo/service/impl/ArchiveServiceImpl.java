package com.example.demo.service.impl;

import com.example.demo.entity.Archive;
import com.example.demo.repository.ArchiveRepository;
import com.example.demo.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    ArchiveRepository archiveRepository;

    @Override
    public void save(Archive archive) {
        archiveRepository.save(archive);
    }

    @Override
    public List<Archive> findAll() {
        return archiveRepository.findAll();
    }

    @Override
    public Archive findById(Long id) {
        return archiveRepository.findArchiveById(id);
    }

    @Override
    public void delete(Long id) {
        archiveRepository.deleteById(id);

    }

    @Override
    public Archive findByPlane(Long id) {
        return archiveRepository.findArchiveByPlane(id);
    }
}
