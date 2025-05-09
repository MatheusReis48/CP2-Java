package com.fiap.brinquedos.controller;

import com.fiap.brinquedos.model.Brinquedo;
import com.fiap.brinquedos.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    @PostMapping
    public ResponseEntity<Brinquedo> criarBrinquedo(@RequestBody Brinquedo brinquedo) {
        try {

            Brinquedo novoBrinquedo = brinquedoRepository.save(brinquedo);
            return new ResponseEntity<>(novoBrinquedo, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<Brinquedo>> listarBrinquedos() {
        try {
            List<Brinquedo> brinquedos = brinquedoRepository.findAll();
            if (brinquedos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(brinquedos, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarBrinquedoPorId(@PathVariable("id") Long id) {
        Optional<Brinquedo> brinquedoData = brinquedoRepository.findById(id);

        if (brinquedoData.isPresent()) {
            return new ResponseEntity<>(brinquedoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
