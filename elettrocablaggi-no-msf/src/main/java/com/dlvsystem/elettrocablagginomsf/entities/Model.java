package com.dlvsystem.elettrocablagginomsf.entities;


import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "model")
public class Model implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -4365271661014512517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project", referencedColumnName = "id")
    private Project project;

    @Column(name = "name")
    private String name;

    @Column(name = "epochs")
    private Integer epochs;

    @Column(name = "learning_rate")
    private Double learningRate;

    @Column(name = "momentum")
    private Double momentum;

    @Column(name = "batch")
    private Integer batch;
}
