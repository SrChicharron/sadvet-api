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

    @PostMapping("/addMascota")
    public ResponseEntity<?> addMascota(@RequestBody Mascota mascota){
        ResponseModelBean response = mascotaService.addMascota(mascota);
        return ResponseEntity.ok(response);
    }
}
