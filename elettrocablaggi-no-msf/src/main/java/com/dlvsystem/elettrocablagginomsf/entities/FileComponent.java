package com.dlvsystem.elettrocablagginomsf.entities;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "file_component")
public class FileComponent implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 5709724855429724422L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "path", length = 255)
    private String path;

    @Column(name = "mimetype", length = 255)
    private String mimetype;

    @Column(name = "name", length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project_component", referencedColumnName = "id")
    private ProjectComponent projectComponent;
}
