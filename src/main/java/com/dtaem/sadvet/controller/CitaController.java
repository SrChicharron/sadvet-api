package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cita;
import com.dtaem.sadvet.service.ICitaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/cita")
public class CitaController {
    private static Logger log = LoggerFactory.getLogger(MascotaController.class);

    @Autowired
    private ICitaService citaService;

    @GetMapping("/getCitas")
    public ResponseEntity<?> getAllCitas(){
        LocalDate fechaActual = LocalDate.now();
        String fecha=fechaActual.toString();
        List<Cita> citas = citaService.getCitasByFecha(fecha);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/getCitaById")
    public ResponseEntity<?> getCitaById(@RequestParam int id){
        Cita cita = citaService.getCitaById(id);
        return ResponseEntity.ok(cita);
    }

    @PostMapping("/addCita")
    public ResponseEntity<?> addCita(@RequestBody Cita cita){
        ResponseModelBean response = citaService.addCita(cita);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateCita")
    public ResponseEntity<?> updateCita(@RequestBody Cita cita){
        ResponseModelBean response = citaService.updateCita(cita);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteCita")
    public ResponseEntity<?> deleteCita(@RequestBody Cita cita){
        ResponseModelBean response = citaService.deleteCita(cita.getId());
        return ResponseEntity.ok(response);
    }
}
