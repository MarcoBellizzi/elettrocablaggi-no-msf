package com.dlvsystem.elettrocablagginomsf.controller;

import com.dlvsystem.elettrocablagginomsf.dto.FileDTO;
import com.dlvsystem.elettrocablagginomsf.dto.ProjectComponentDTO;
import com.dlvsystem.elettrocablagginomsf.service.FileService;
import com.dlvsystem.elettrocablagginomsf.service.ProjectComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/controller")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private ProjectComponentService projectComponentService;

    @Autowired
    private FileService fileService;

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

    @PostMapping("/upload-file-component")
    public ResponseEntity<List<ProjectComponentDTO>> uploadFileComponent(@RequestParam(name = "componentID", required = true) Long componentID,
                                                                         @RequestParam(name = "file", required = true) final MultipartFile file)
    {
        fileService.uploadFileComponent(componentID, file);
        return ResponseEntity.ok(projectComponentService.getComponents());
    }

    @GetMapping("/get-file")
    public ResponseEntity<Resource> getFile(@RequestParam(name = "id", required = true) Long id)
    {
        FileDTO file = fileService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline" + "; filename=\"" + file.getName() + "\"")//$NON-NLS-1$//$NON-NLS-2$
                .contentLength(file.getSize()).contentType(MediaType.parseMediaType(file.getMimeType())).body(file.getFile());


    }
}
