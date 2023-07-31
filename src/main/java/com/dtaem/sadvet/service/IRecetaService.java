package com.dtaem.sadvet.service;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Receta;

import java.util.List;

public interface IRecetaService {

    List<Receta> getAllReceta();

    ResponseModelBean addReceta(Receta receta);

    ResponseModelBean updateReceta(Receta receta);

    ResponseModelBean deleteReceta(int id);

    ResponseModelBean deleteAll();

    Float getSum();
}
