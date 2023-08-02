package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Producto;
import com.dtaem.sadvet.service.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/producto")
public class ProductoController {
    private static Logger log = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    IProductoService productoService;

    @GetMapping("/getProductos")
    public ResponseEntity<?> getProductos() {
        List<Producto> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/getProductoById")
    public ResponseEntity<?> getProductoById(@RequestParam int id) {
        Producto producto = productoService.getProductoById(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping("/addProducto")
    public ResponseEntity<?> addProducto(@RequestBody Producto producto) {
        ResponseModelBean response = productoService.addProducto(producto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateProducto")
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto) {
        ResponseModelBean response = productoService.updateProducto(producto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteProducto")
    public ResponseEntity<?> deleteProducto(@RequestBody Producto producto) {
        ResponseModelBean response = productoService.deleteProducto(producto.getId());
        return ResponseEntity.ok(response);
    }
}
