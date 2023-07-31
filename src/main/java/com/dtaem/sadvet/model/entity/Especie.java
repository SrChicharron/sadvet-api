package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "ESPECIE")
@Table(name = "ESPECIE")
public class Especie implements Serializable {
    @Serial
    private static final long serialVersionUID = -1204117218034102310L;

    public static final String TABLE_NAME= "ESPECIE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "ESPECIE")
    private String especie;
}
