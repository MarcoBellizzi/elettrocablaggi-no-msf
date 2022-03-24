package com.dlvsystem.elettrocablagginomsf.entities;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "project")
public class Project implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 3125501067589650177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "id_cad_image", referencedColumnName = "id")
    private FileProject cadImage;

    @OneToOne
    @JoinColumn(name = "id_panel_image", referencedColumnName = "id")
    private FileProject panelImage;

}

