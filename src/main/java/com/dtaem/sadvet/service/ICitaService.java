package com.dtaem.sadvet.service;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cita;

import java.util.List;

public interface ICitaService {

    List<Cita> getCitasByFecha(String fecha);

    Cita getCitaById(int id);

    ResponseModelBean addCita(Cita cita);

    ResponseModelBean updateCita(Cita cita);

    ResponseModelBean deleteCita(int id);
}
