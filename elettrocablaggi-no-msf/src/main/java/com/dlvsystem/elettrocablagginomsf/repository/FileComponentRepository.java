package com.dlvsystem.elettrocablagginomsf.repository;

import com.dlvsystem.elettrocablagginomsf.entities.FileComponent;
import com.dlvsystem.elettrocablagginomsf.entities.ProjectComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileComponentRepository extends JpaRepository<FileComponent, Long> {
    List<FileComponent> findByProjectComponent(ProjectComponent projectComponent);
}
