package com.dlvsystem.elettrocablagginomsf.service.impl;

import com.dlvsystem.elettrocablagginomsf.dto.FileDTO;
import com.dlvsystem.elettrocablagginomsf.entities.FileComponent;
import com.dlvsystem.elettrocablagginomsf.entities.ProjectComponent;
import com.dlvsystem.elettrocablagginomsf.repository.FileComponentRepository;
import com.dlvsystem.elettrocablagginomsf.repository.ProjectComponentRepository;
import com.dlvsystem.elettrocablagginomsf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Autowired
    private FileComponentRepository fileComponentRepository;

    @Value("${service.path_file_repository}")
    private String pathFileRepository;

    @Override
    public void uploadFileComponent(Long componentID, MultipartFile file) {
        ProjectComponent component = projectComponentRepository.findById(componentID).orElseThrow(() ->
                new RuntimeException("component not found"));

        final Path folderPath = Paths.get(pathFileRepository, "files", "components", componentID + ""); //$NON-NLS-1$ //$NON-NLS-2$
        final Path filePath = Paths.get(pathFileRepository, "files", "components", componentID + "", file.getOriginalFilename()); //$NON-NLS-1$ //$NON-NLS-2$

        if (!file.isEmpty())
        {

            final FileComponent f = new FileComponent();
            f.setPath(filePath.toString());
            f.setName(file.getOriginalFilename());
            f.setMimetype(file.getContentType());
         //   f.setSize(file.getSize());
            f.setProjectComponent(component);
            fileComponentRepository.save(f);

            try
            {
                Files.createDirectories(folderPath);
                Files.write(filePath, file.getBytes());
            }
            catch (final IOException e)
            {
                e.printStackTrace();
            }

        }

    }

    private static byte[] getContent(final FileComponent file)
    {
        final Path path = Paths.get(file.getPath());
        try
        {
            return Files.readAllBytes(path);
        }
        catch (final Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public FileDTO getFile(Long id) {
        FileComponent file = fileComponentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("file not found"));

        FileDTO f = new FileDTO();
        f.setId(id);
        f.setName(file.getName());
        f.setMimeType(file.getMimetype());

        Resource resource = null;
        try
        {
            resource =  new ByteArrayResource(getContent(file));
            f.setSize(resource.contentLength());
        }
        catch (final Exception e)
        {
            throw new RuntimeException(e.getStackTrace().toString());
        }

        if (resource.exists() || resource.isReadable())
        {
            f.setFile(resource);
        }
        return f;
    }
}
