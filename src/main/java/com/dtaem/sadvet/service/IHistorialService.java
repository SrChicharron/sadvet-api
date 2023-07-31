package com.dtaem.sadvet.service;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Historial;

import java.util.List;

public interface IHistorialService {

    List<Historial> getAllHistorial();

    List<Historial> getHistorialById(int id);

    ResponseModelBean addHistorial(Historial historial);

    ResponseModelBean updateHistorial(Historial historial);

    ResponseModelBean deleteHistorial(int id);
}
