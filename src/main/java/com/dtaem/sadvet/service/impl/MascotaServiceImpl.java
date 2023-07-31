package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Mascota;
import com.dtaem.sadvet.repository.IMascotaRepository;
import com.dtaem.sadvet.service.IMascotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {

    private static Logger log = LoggerFactory.getLogger(MascotaServiceImpl.class);

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotasByIdCliente(int idCliente) {
        List<Mascota> mascotas = new ArrayList<>();
        if(idCliente==0){
            mascotaRepository.findAll().forEach(mascotas::add);
        }else{
            mascotaRepository.findAllByIdCliente(idCliente).forEach(mascotas::add);
        }
        return mascotas;
    }

    @Override
    public Mascota getMascotaById(int id) {
        Mascota mascota = null;
        mascota = mascotaRepository.findById(id).orElse(new Mascota());
        return mascota;
    }

    @Override
    public ResponseModelBean addMascota(Mascota mascota) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Mascota savedMascota = mascotaRepository.save(mascota);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateMascota(Mascota mascota) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Mascota savedMascota = mascotaRepository.save(mascota);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteMascota(int id) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            System.out.println(id);
            mascotaRepository.deleteById(id);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }
}
