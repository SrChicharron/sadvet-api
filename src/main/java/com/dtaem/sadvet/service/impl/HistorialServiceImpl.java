package com.dtaem.sadvet.service.impl;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Historial;
import com.dtaem.sadvet.repository.IHistorialRepository;
import com.dtaem.sadvet.service.IHistorialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistorialServiceImpl implements IHistorialService {
    private static Logger log = LoggerFactory.getLogger(HistorialServiceImpl.class);

    @Autowired
    private IHistorialRepository historialRepository;
    @Override
    public List<Historial> getAllHistorial() {
        List<Historial>historiales= new ArrayList<>();
        historialRepository.findAll().forEach(historiales::add);
        return historiales;
    }

    @Override
    public List<Historial> getHistorialById(int id) {
        List<Historial>historiales= new ArrayList<>();
        historialRepository.findByIdMascota(id).forEach(historiales::add);
        return historiales;
    }

    @Override
    public ResponseModelBean addHistorial(Historial historial) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Historial savedHistorial = historialRepository.save(historial);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean updateHistorial(Historial historial) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            Historial savedHistorial = historialRepository.save(historial);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }

    @Override
    public ResponseModelBean deleteHistorial(int id) {
        ResponseModelBean response = new ResponseModelBean();
        try{
            historialRepository.deleteById(id);
            response.setReturnCode(0);
        }catch(Exception e){
            log.info(e.getMessage());
            response.setReturnCode(1);
        }
        return response;
    }
}
