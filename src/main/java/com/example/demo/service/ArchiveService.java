package com.example.demo.service;

import com.example.demo.entity.Archive;

public interface ArchiveService extends GeneralService<Archive>{
    Archive findByPlane(Long id);

}
