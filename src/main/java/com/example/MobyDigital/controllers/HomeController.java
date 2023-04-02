package com.example.MobyDigital.controllers;

import com.example.MobyDigital.entities.*;
import com.example.MobyDigital.exceptions.Miexcepcion;
import com.example.MobyDigital.services.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    CuentaService cta;

    @PostMapping("/crearCandidato")
    public String crearCandidato(@RequestBody Candidato candidato){

        logger.info("ingreso un candidato para insertar a la base de datos");


        LocalDate fechadeNac = candidato.getFechaNac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date fechaNacSql = Date.valueOf(fechadeNac);

    cta.crearCandidato(candidato.getNombre(),candidato.getApellido(),candidato.getTipo(),candidato.getDocnum(),fechaNacSql);
    return "Usuario creado correctamente";
    }

    @PostMapping("/crearTecnologia")
    public String crearTecnologia(@RequestBody Tecnologias tecno){
        cta.crearTecnologia(tecno.getTecnologia(),tecno.getVersion());
        return "";}

    @PostMapping("/crearCandxTecn")
    public String crearCandxTecn(@RequestBody CandidatoxTecnologia cand) throws Miexcepcion {

        if (cand.getAñosExperiencia() <=0 ) {
            throw new Miexcepcion("La experiencia debe ser mayor a 0 años");
        }else {
            cta.crearCandxTec(cand.getAñosExperiencia(), cand.getIdTecnologia(), cand.getAñosExperiencia());
        }

        return "Candidato por tecnología creado correctamente";
    }

    @PostMapping("/buscarCandxTecnologia")
    public List<Candidato> Candidatos(@RequestBody Tecnologias tecnologias){

        return cta.buscarCandidatoxTecnologia(tecnologias.getTecnologia());

    }

    @GetMapping("/read")
    public List<Candidato> read(){
        return cta.buscarCandidatoxTecn();
    }






}
