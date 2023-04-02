package com.example.MobyDigital.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Candidato")
public class CandidatoJpa {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Integer IdCandidato;

        @Column(name = "Nombre")
        public String nombre;
        @Column(name = "Apellido")
        public String apellido;
        @Column(name = "DocTipo")
        public String docTipo;
        @Column(name = "NumeroDoc")
        public Integer numeroDoc;
        @Column(name = "FechaNac")
        public Date fechaNac;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "CandidatoxTecnologia",
        joinColumns = @JoinColumn(name = "idCandidato"),
        inverseJoinColumns = @JoinColumn(name = "IdTecnologia"))
        public List<TecnologiasJpa> tec;

    public List<TecnologiasJpa> getTec() {
        return tec;
    }

    public Integer getIdCandidato() {
        return IdCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        IdCandidato = idCandidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocTipo() {
        return docTipo;
    }

    public void setDocTipo(String docTipo) {
        this.docTipo = docTipo;
    }

    public Integer getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(Integer numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setTec(List<TecnologiasJpa> tec) {
        this.tec = tec;
    }
}



