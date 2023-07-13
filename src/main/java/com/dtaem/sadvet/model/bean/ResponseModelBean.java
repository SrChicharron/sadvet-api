package com.dtaem.sadvet.model.bean;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ResponseModelBean implements Serializable {

    @Serial
    private static final long serialVersionUID = 4623716302008137510L;
    private int ReturnCode; 
}
