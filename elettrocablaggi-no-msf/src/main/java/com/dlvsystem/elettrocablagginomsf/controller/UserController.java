package com.dlvsystem.elettrocablagginomsf.controller;

import com.dlvsystem.elettrocablagginomsf.dto.ProjectComponentDTO;
import com.dlvsystem.elettrocablagginomsf.service.ProjectComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private ProjectComponentService projectComponentService;

    @GetMapping("/get-components")
    public ResponseEntity<List<ProjectComponentDTO>> getComponents() {
        return ResponseEntity.ok(projectComponentService.getComponents());
    }

    @PutMapping("add-component")
    public ResponseEntity<List<ProjectComponentDTO>> addComponent(@RequestBody(required = true) ProjectComponentDTO component) {
        projectComponentService.addComponent(component);
        return ResponseEntity.ok(projectComponentService.getComponents());
    }

    @GetMapping("delete-component")
    public ResponseEntity<List<ProjectComponentDTO>> deleteComponent(@RequestParam(name = "componentID", required = true) Long componentID) {
        projectComponentService.deleteComponent(componentID);
        return ResponseEntity.ok(projectComponentService.getComponents());
    }
}
