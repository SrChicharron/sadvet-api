package com.dtaem.sadvet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "MASCOTA")
@Table(name = "MASCOTA")
public class Mascota implements Serializable {
    @Serial
    private static final long serialVersionUID = -2250189424064607254L;

    public static final String TABLE_NAME= "MASCOTA";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

    @Basic(optional = false)
    @Column(name = "PESO")
    private Float peso;

    @Basic(optional = false)
    @Column(name = "NOTAS")
    private String notas;

    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private int idCliente;

    @Basic(optional = true)
    @Column(name = "ID_SEXO")
    private int idSexo;

    @Basic(optional = true)
    @Column(name = "ID_ESPECIE")
    private int idEspecie;

    @Basic(optional = true)
    @Column(name = "RAZA")
    private String raza;
}
