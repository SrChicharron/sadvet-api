package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "HISTORIAL")
@Table(name = "HISTORIAL")
public class Historial {

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
    @Column(name = "ID_MASCOTA")
    private int idMascota;

    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private int idCliente;
}
