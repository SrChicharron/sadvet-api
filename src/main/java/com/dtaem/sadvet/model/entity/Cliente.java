package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "CLIENTE")
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = -8310444991925765315L;

    public static final String TABLE_NAME= "CLIENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @NotEmpty
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @NotEmpty
    @Column(name = "APELLIDOS")
    private String apellidos;

    @Basic(optional = false)
    @NotEmpty
    @Column(name = "TELEFONO")
    private String telefono;

    @Basic(optional = false)
    @NotEmpty
    @Column(name = "EMAIL")
    private String email;

}
