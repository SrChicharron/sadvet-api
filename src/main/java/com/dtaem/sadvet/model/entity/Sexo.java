package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "SEXO")
@Table(name = "SEXO")
public class Sexo implements Serializable {
    @Serial
    private static final long serialVersionUID = -159613641454749044L;

    public static final String TABLE_NAME= "SEXO";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "SEXO")
    private String sexo;
}
