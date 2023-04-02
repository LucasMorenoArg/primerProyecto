package com.example.MobyDigital.entities;

import java.util.Date;

public class Candidato {

    public String nombre;
    public String apellido;
    public String tipo;
    public Integer Docnum;
    public Date fechaNac;
    public Tecnologias tec;


    public void setDocnum(Integer docnum) {
        Docnum = docnum;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Tecnologias getTec() {
        return tec;
    }
    public void setTec(Tecnologias tec) {
        this.tec = tec;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDocnum() {
        return Docnum;
    }

    public void setDocnum(int docnum) {
        Docnum = docnum;
    }

    @Override
    public String toString() {
        return "Candidato {" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipo='" + tipo + '\'' +
                ", Docnum=" + Docnum +
                ", fechadeNac=" + fechaNac +
                ", tec=" + tec +
                '}';
    }
}


