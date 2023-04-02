package com.example.MobyDigital.entities;

import javax.persistence.*;

@Entity
@Table(name = "Tecnologias")
public class TecnologiasJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idTecnologia;
    public String tecnologia;
    public int version;

    public Integer getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(Integer idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public void setIdTecnologia(int idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
