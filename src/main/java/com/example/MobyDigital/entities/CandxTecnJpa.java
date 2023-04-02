package com.example.MobyDigital.entities;

import javax.persistence.*;

@Entity
@Table(name = "CandidatoxTecnologia")
public class CandxTecnJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idCandidato;
    public int IdTecnologia;
    public int añosExperiencia;

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getIdTecnologia() {
        return IdTecnologia;
    }

    public void setIdTecnologia(int idTecnologia) {
        IdTecnologia = idTecnologia;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
}

