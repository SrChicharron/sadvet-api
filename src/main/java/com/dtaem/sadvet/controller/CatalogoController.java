package com.dtaem.sadvet.controller;

import com.dtaem.sadvet.model.entity.Especie;
import com.dtaem.sadvet.model.entity.Sexo;
import com.dtaem.sadvet.repository.IEspecieRepository;
import com.dtaem.sadvet.repository.ISexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sadvet/catalogo")
public class CatalogoController {

    @Autowired
    private ISexoRepository sexoRepository;

    @Autowired
    private IEspecieRepository especieRepository;

    @GetMapping("/getSexo")
    public ResponseEntity<?> getSexo() {
        List<Sexo> lista = sexoRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/getEspecie")
    public ResponseEntity<?> getEspecie() {
        List<Especie> lista = especieRepository.findAll();
        return ResponseEntity.ok(lista);
    }
}
