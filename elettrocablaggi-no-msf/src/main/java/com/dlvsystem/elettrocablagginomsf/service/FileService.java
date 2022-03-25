package com.dlvsystem.elettrocablagginomsf.service;

import com.dlvsystem.elettrocablagginomsf.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void uploadFileComponent(Long componentID, MultipartFile file);
    FileDTO getFile(Long id);
}
