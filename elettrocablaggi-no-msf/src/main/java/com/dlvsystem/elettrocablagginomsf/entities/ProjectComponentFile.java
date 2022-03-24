package com.dlvsystem.elettrocablagginomsf.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "project_component_file")
public class ProjectComponentFile implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -3023583953091049741L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project_component", referencedColumnName = "id")
    private ProjectComponent projectComponent;

    //    @ManyToOne(fetch = FetchType.LAZY)
    //    @JoinColumn(name = "id_file", referencedColumnName = "id")
    //    private File file;

}

