package com.dtaem.sadvet.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity(name = "ROL")
@Table(name = "ROL")
public class Rol implements Serializable {

    @Serial
    private static final long serialVersionUID = -3687749937737990902L;

    public static final String TABLE_NAME= "ROL";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Basic(optional = false)
    private int id;

    @Column(name = "AUTHORITY")
    @NotEmpty
    @Basic(optional = false)
    private String authority;
    @Column(name = "USERNAME")
    @NotEmpty
    @Basic(optional = false)
    private String username;
}
