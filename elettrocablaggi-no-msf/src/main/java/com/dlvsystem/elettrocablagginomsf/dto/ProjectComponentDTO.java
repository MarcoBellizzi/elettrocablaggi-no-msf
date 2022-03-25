package com.dlvsystem.elettrocablagginomsf.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectComponentDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String supplier;

    private List<String> projects = new ArrayList<>();

    private List<String> files = new ArrayList<>();

    private List<Long> filesID = new ArrayList<>();

    private Boolean updating;

    private Boolean expanded;

    private Boolean creating;
}
