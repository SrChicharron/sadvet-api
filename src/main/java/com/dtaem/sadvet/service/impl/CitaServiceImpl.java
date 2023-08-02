package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cita;
import com.dtaem.sadvet.repository.ICitaRepository;
import com.dtaem.sadvet.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaRepository citaRepository;

    @Override
    public List<Cita> getCitasByFecha(String fecha) {
        List<Cita> citas = new ArrayList<>();
        citaRepository.getAllByFechaGreaterThanEqualOrderByFecha(fecha).forEach(citas::add);
        return citas;
    }

    @Override
    public Cita getCitaById(int id) {
        Cita cita = null;
        cita=citaRepository.findById(id).orElse(new Cita());
        return cita;
    }

    @Override
    public ResponseModelBean addCita(Cita cita) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Cita savedCita = citaRepository.save(cita);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateCita(Cita cita) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Cita savedCita = citaRepository.save(cita);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteCita(int id) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            citaRepository.deleteById(id);
            response.setReturnCode(0);
        }catch(Exception e){
            response.setReturnCode(1);
        }
        return response;
    }
}
