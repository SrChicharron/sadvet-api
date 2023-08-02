package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.EmailDetailsBean;
import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cliente;
import com.dtaem.sadvet.model.entity.Producto;
import com.dtaem.sadvet.model.entity.Receta;
import com.dtaem.sadvet.service.IClienteService;
import com.dtaem.sadvet.service.IProductoService;
import com.dtaem.sadvet.service.IRecetaService;
import com.dtaem.sadvet.service.impl.EmailServiceImpl;
import com.dtaem.sadvet.util.PDFCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/receta")
public class RecetaController {
    private static Logger log = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    IRecetaService recetaService;

    @Autowired
    IProductoService productoService;

    @Autowired
    IClienteService clienteService;

    @Autowired
    EmailServiceImpl emailService;

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
    public ResponseEntity<?> enviar(@RequestParam int id) {
        PDFCreator pdfCreator= new PDFCreator();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        String formattedDateTime = currentDateTime.format(formatter);
        List<Receta> productos = recetaService.getAllReceta();
        Optional<Cliente> cliente = clienteService.findClienteById(id);
        EmailDetailsBean email = new EmailDetailsBean();
        email.setSubject("Sistema de Administracion Veterinaria");
        email.setRecipient(cliente.get().getEmail());
        email.setMsgBody("Te compartimos tu receta del dia "+formattedDateTime);
        email.setProductos(productos);
        email.setAttachment("receta"+formattedDateTime+".pdf");
        pdfCreator.createPDF(email,formattedDateTime);
        String respuesta=emailService.sendMailWithAttachment(email);
        pdfCreator.deleteFile(email.getAttachment());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/total")
    public ResponseEntity<?> total() {
        Float sum = recetaService.getSum();
        return ResponseEntity.ok(sum);
    }
    private void sumar(Float suma, Float adicion){
        suma+=adicion;
    }
}
