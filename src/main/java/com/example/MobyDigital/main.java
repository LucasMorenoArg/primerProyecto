package com.example.MobyDigital;

import com.example.MobyDigital.Interfaz.CandidatoRepository;
import com.example.MobyDigital.entities.Candidato;
import com.example.MobyDigital.services.CandidatoService;
import com.example.MobyDigital.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;

public class main {




    public static void main(String[] args) {

        CuentaService ctasvc= new CuentaService();
        LocalDate fecha = LocalDate.parse("1985-08-29");
        Date date1 = java.sql.Date.valueOf(fecha);
        Candidato cand= new Candidato();


        CandidatoService candsrvc= new CandidatoService();


        //System.out.println( candsrvc.repos());










    }
}
