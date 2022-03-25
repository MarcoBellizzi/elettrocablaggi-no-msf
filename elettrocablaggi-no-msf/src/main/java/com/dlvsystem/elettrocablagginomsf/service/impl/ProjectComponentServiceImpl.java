package com.dlvsystem.elettrocablagginomsf.service.impl;

import com.dlvsystem.elettrocablagginomsf.dto.FileDTO;
import com.dlvsystem.elettrocablagginomsf.dto.ProjectComponentDTO;
import com.dlvsystem.elettrocablagginomsf.entities.FileComponent;
import com.dlvsystem.elettrocablagginomsf.entities.ProjectComponent;
import com.dlvsystem.elettrocablagginomsf.repository.FileComponentRepository;
import com.dlvsystem.elettrocablagginomsf.repository.ProjectComponentRepository;
import com.dlvsystem.elettrocablagginomsf.service.ProjectComponentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectComponentServiceImpl implements ProjectComponentService {

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Autowired
    private FileComponentRepository fileComponentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProjectComponentDTO> getComponents() {
        List<ProjectComponentDTO> components = new ArrayList<>();
        for (ProjectComponent component : projectComponentRepository.findAll()) {
            ProjectComponentDTO comp = modelMapper.map(component, ProjectComponentDTO.class);

            // TO-DO find the projects in which there is the component
            comp.setProjects(new ArrayList<>());

            comp.setFilesID(new ArrayList<>());
            for (FileComponent file : fileComponentRepository.findByProjectComponent(component)) {
                comp.getFilesID().add(file.getId());
            }

            comp.setUpdating(false);
            comp.setCreating(false);
            comp.setExpanded(false);

            components.add(comp);
        }
        return components;
    }

    @Override
    public void addComponent(ProjectComponentDTO component) {
        projectComponentRepository.save(modelMapper.map(component, ProjectComponent.class)).getId();
    }

    @Override
    public void deleteComponent(Long id) {
        ProjectComponent component = projectComponentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("component not found"));
        projectComponentRepository.delete(component);
    }
}
