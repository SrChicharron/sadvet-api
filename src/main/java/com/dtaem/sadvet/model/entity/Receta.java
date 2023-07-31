package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "RECETA")
@Table(name = "RECETA")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;

    @Basic(optional = false)
    @Column(name = "PRECIO")
    private float precio;

    @Basic(optional = false)
    @Column(name = "SUBTOTAL")
    private float subtotal;

    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;
}
