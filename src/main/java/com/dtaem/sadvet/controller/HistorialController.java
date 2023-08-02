package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Historial;
import com.dtaem.sadvet.service.IHistorialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/historial")
public class HistorialController {

    private static Logger log = LoggerFactory.getLogger(HistorialController.class);

    @Autowired
    IHistorialService historialService;

    @GetMapping("/getHistorial")
    public ResponseEntity<?> getHistorial() {
        List<Historial> historial = historialService.getAllHistorial();
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/getHistorialById")
    public ResponseEntity<?> getProductoById(@RequestParam int id) {
        List<Historial> historial = historialService.getHistorialById(id);
        return ResponseEntity.ok(historial);
    }

    @PostMapping("/addHistorial")
    public ResponseEntity<?> addProducto(@RequestBody Historial historial) {
        ResponseModelBean response = historialService.addHistorial(historial);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateHistorial")
    public ResponseEntity<?> updateProducto(@RequestBody Historial historial) {
        ResponseModelBean response = historialService.updateHistorial(historial);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteHistorial")
    public ResponseEntity<?> deleteProducto(@RequestBody Historial historial) {
        ResponseModelBean response = historialService.deleteHistorial(historial.getId());
        return ResponseEntity.ok(response);
    }
}
