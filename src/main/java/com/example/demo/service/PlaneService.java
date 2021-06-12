package com.example.demo.service;

import com.example.demo.entity.Plane;

public interface PlaneService extends GeneralService <Plane>{
    Plane findByBrand(String brand);



}
