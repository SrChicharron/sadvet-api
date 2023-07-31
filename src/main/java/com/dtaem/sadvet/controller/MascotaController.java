package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Mascota;
import com.dtaem.sadvet.service.IMascotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/mascota")
public class MascotaController {
    private static Logger log = LoggerFactory.getLogger(MascotaController.class);

    @Autowired
    IMascotaService mascotaService;

    @GetMapping("/getMascotasByIdCliente")
    public ResponseEntity<?> getMascotasByIdCliente(@RequestParam int id) {
        List<Mascota> mascotas = mascotaService.getMascotasByIdCliente(id);
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/getMascotaById")
    public ResponseEntity<?> getMascotaById(@RequestParam int id) {
        Mascota mascota = mascotaService.getMascotaById(id);
        return ResponseEntity.ok(mascota);
    }

    @PostMapping("/addMascota")
    public ResponseEntity<?> addMascota(@RequestBody Mascota mascota){
        ResponseModelBean response = mascotaService.addMascota(mascota);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateMascota")
    public ResponseEntity<?> updateMascota(@RequestBody Mascota mascota){
        ResponseModelBean response = mascotaService.updateMascota(mascota);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteMascota")
    public ResponseEntity<?> deleteMascota(@RequestBody Mascota mascota){
        ResponseModelBean response = mascotaService.deleteMascota(mascota.getId());
        return ResponseEntity.ok(response);
    }
}
