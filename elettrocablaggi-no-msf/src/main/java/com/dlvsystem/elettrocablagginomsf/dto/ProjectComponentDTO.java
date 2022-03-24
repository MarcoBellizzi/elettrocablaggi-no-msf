package com.dlvsystem.elettrocablagginomsf.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProjectComponentDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String supplier;

    private List<String> projects;

    private List<Object> files;

    private Boolean updating;

    private Boolean expanded;

    private Boolean creating;
}
