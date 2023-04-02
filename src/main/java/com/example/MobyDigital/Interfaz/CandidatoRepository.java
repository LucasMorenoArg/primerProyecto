package com.example.MobyDigital.Interfaz;

import com.example.MobyDigital.entities.Candidato;
import com.example.MobyDigital.entities.CandidatoJpa;
import com.example.MobyDigital.entities.TecnologiasJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoJpa,Integer> {

   List<CandidatoJpa> findAllByNombre(String nombre);
}
