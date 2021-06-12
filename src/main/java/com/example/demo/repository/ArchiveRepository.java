package com.example.demo.repository;

import com.example.demo.entity.Archive;
import com.example.demo.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {

    Archive findArchiveById(Long id);

    Archive findArchiveByPlane(Long id);
}
