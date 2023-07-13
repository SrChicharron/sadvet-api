package com.dtaem.sadvet.service;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Mascota;

import java.util.List;

public interface IMascotaService{

    List<Mascota> getMascotasByIdCliente(int idCliente);

    ResponseModelBean addMascota(Mascota mascota);

    ResponseModelBean updateMascota(Mascota mascota);

    ResponseModelBean deleteMascota(int id);
}
