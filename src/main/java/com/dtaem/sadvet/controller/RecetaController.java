package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Producto;
import com.dtaem.sadvet.model.entity.Receta;
import com.dtaem.sadvet.service.IProductoService;
import com.dtaem.sadvet.service.IRecetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/receta")
public class RecetaController {
    private static Logger log = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    IRecetaService recetaService;

    @Autowired
    IProductoService productoService;

    @GetMapping("/getReceta")
    public ResponseEntity<?> getReceta() {
        List<Receta> receta = recetaService.getAllReceta();
        return ResponseEntity.ok(receta);
    }


    @PostMapping("/addReceta")
    public ResponseEntity<?> addReceta(@RequestBody Receta receta) {
        Producto producto=productoService.getProductoById(receta.getIdProducto());
        receta.setNombre(producto.getNombre());
        receta.setPrecio(producto.getPrecio());
        receta.setSubtotal(receta.getPrecio()*receta.getCantidad());
        ResponseModelBean response = recetaService.addReceta(receta);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateReceta")
    public ResponseEntity<?> updateProducto(@RequestBody Receta receta) {
        Producto producto=productoService.getProductoById(receta.getIdProducto());
        receta.setNombre(producto.getNombre());
        receta.setPrecio(producto.getPrecio());
        receta.setSubtotal(receta.getPrecio()*receta.getCantidad());
        ResponseModelBean response = recetaService.updateReceta(receta);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteReceta")
    public ResponseEntity<?> deleteReceta(@RequestBody Receta receta) {
        ResponseModelBean response = recetaService.deleteReceta(receta.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {
        ResponseModelBean response = recetaService.deleteAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/enviar")
    public ResponseEntity<?> enviar() {
        ResponseModelBean response = recetaService.deleteAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/total")
    public ResponseEntity<?> total() {
        Float sum = recetaService.getSum();
        return ResponseEntity.ok(sum);
    }
}
