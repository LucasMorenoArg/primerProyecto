package com.example.MobyDigital.controllers;

import com.example.MobyDigital.entities.CandidatoJpa;
import com.example.MobyDigital.entities.TecnologiasJpa;
import com.example.MobyDigital.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeControllerJPA {

    @Autowired
    private CandidatoService candidatoService;



    @PostMapping("/readjpa")
    public  Optional<CandidatoJpa> readCand(@RequestBody CandidatoJpa candidatoJpa){

        Optional<CandidatoJpa> optional=candidatoService.read(candidatoJpa.getIdCandidato());

        return optional;
    }

    @PostMapping("/crearCandidatojpa")
    public void crearCandidatojpa(@RequestBody CandidatoJpa candidatoJpa){

        LocalDate FechaNac = candidatoJpa.getFechaNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date fechaNacSql = Date.valueOf(FechaNac);
        candidatoService.crearCandidatoJpa(candidatoJpa.getNombre(),candidatoJpa.getApellido(),candidatoJpa.getDocTipo(),
                candidatoJpa.getNumeroDoc(),fechaNacSql);
    }

    @PostMapping("/crearTecnologiajpa")
    public void crearTecnologiajpa(@RequestBody TecnologiasJpa tecnologiasJpa){


        candidatoService.crearTecnologia(tecnologiasJpa.getTecnologia(),tecnologiasJpa.getVersion());
    }

    @GetMapping("/consulta")
    public List<CandidatoJpa> consulta() {
        return candidatoService.select();
    }

}
