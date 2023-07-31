package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "CITA")
@Table(name = "CITA")
public class Cita implements Serializable {
    @Serial
    private static final long serialVersionUID = -9010701537611153086L;

    public static final String TABLE_NAME= "CITA";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "FECHA")
    private String fecha;

    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private int idCliente;

    @Basic(optional = false)
    @Column(name = "ID_MASCOTA")
    private int idMascota;
}
