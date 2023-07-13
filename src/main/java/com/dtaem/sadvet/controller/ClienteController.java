package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.bean.ResponseModelBean;
import com.dtaem.sadvet.model.entity.Cliente;
import com.dtaem.sadvet.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/cliente")
public class ClienteController {
    private static Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/getClientes")
    public ResponseEntity<?> getAllClientes() {
        List<Cliente> list = clienteService.getAllClientes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getClienteById")
    public ResponseEntity<?> getClienteById(@RequestParam int id) {
        Optional<Cliente> cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/addCliente")
    public ResponseEntity<?> addCliente(@RequestBody Cliente cliente) {
        log.atInfo().log("Se recibe peticion: add cliente");
        ResponseModelBean response = clienteService.addCliente(cliente);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateCliente")
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente) {
        log.atInfo().log("Se recibe peticion: update cliente");
        ResponseModelBean response = clienteService.updateCliente(cliente);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/deleteCliente")
    public ResponseEntity<?> deleteCliente(@RequestBody Cliente cliente) {
        log.atInfo().log("Se recibe peticion: delete Cliente");
        ResponseModelBean response = clienteService.deleteCliente(cliente.getId());
        return ResponseEntity.ok(response);
    }
}
