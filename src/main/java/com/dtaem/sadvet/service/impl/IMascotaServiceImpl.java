package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Mascota;
import com.dtaem.sadvet.repository.IMascotaRepository;
import com.dtaem.sadvet.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotasByIdCliente(int idCliente) {
        List<Mascota> mascotas = new ArrayList<>();
        mascotaRepository.findAllByIdCliente(idCliente).forEach(mascotas::add);;
        return mascotas;
    }

    @Override
    public ResponseModelBean addMascota(Mascota mascota) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Mascota savedMascota = mascotaRepository.save(mascota);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateMascota(Mascota mascota) {
        return null;
    }

    @Override
    public ResponseModelBean deleteMascota(int id) {
        return null;
    }
}
