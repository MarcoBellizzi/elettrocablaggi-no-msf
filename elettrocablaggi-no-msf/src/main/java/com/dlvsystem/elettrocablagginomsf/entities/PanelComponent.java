package com.dlvsystem.elettrocablagginomsf.entities;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "panel_component")
public class PanelComponent implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 2110160947359179320L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", referencedColumnName = "id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_component", referencedColumnName = "id")
    private ProjectComponent projectComponent;

    @Column(name = "is_cad_component")
    private Boolean isCadComponent;

    @Column(name = "x")
    private Double x;

    @Column(name = "y")
    private Double y;

    @Column(name = "h")
    private Double h;

    @Column(name = "w")
    private Double w;
}
