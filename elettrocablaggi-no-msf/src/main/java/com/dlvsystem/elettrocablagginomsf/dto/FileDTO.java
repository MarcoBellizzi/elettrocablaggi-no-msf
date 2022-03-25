package com.dlvsystem.elettrocablagginomsf.dto;

import lombok.Data;
import org.springframework.core.io.Resource;

import java.io.Serializable;

@Data
public class FileDTO implements Serializable {

    private Long id;

    private String name;

    private String mimeType;

    private Long size;

    private Resource file;
}
