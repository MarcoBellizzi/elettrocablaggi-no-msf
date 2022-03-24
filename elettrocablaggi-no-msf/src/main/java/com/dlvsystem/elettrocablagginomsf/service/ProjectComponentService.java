package com.dlvsystem.elettrocablagginomsf.service;

import com.dlvsystem.elettrocablagginomsf.dto.ProjectComponentDTO;

import java.util.List;

public interface ProjectComponentService {
    List<ProjectComponentDTO> getComponents();
    void addComponent(ProjectComponentDTO component);
    void deleteComponent(Long id);
}
