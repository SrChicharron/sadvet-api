package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "PRODUCTO")
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 4520178648833189334L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;

    @Column(name = "NOMBRE")
    @NotEmpty
    @Basic(optional = false)
    private String nombre;

    @Column(name = "DESCRIPCION")
    @NotEmpty
    @Basic(optional = false)
    private String descripcion;

    @Column(name = "PRECIO")
    @Basic(optional = false)
    private Float precio;
}
