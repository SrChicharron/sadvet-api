package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Historial;
import com.dtaem.sadvet.model.entity.Receta;
import com.dtaem.sadvet.repository.IRecetaRepository;
import com.dtaem.sadvet.service.IRecetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetaServiceImpl implements IRecetaService {
    private static Logger log = LoggerFactory.getLogger(RecetaServiceImpl.class);
    @Autowired
    IRecetaRepository recetaRepository;
    @Override
    public List<Receta> getAllReceta() {
        List<Receta> receta = new ArrayList<>();
        recetaRepository.findAll().forEach(receta::add);
        return receta;
    }

    @Override
    public ResponseModelBean addReceta(Receta receta) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Receta savedReceta = recetaRepository.save(receta);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateReceta(Receta receta) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Receta savedReceta = recetaRepository.save(receta);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteReceta(int id) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            recetaRepository.deleteById(id);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteAll() {
        ResponseModelBean response = new ResponseModelBean();
        try{
            recetaRepository.deleteAll();
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public Float getSum() {
        return recetaRepository.getSumBySubtotal();
    }
}
