package com.dlvsystem.elettrocablagginomsf.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "file_project")
public class FileProject implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 5709724855429724422L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
