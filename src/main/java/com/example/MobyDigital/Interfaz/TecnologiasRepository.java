package com.example.MobyDigital.Interfaz;

import com.example.MobyDigital.entities.CandidatoJpa;
import com.example.MobyDigital.entities.TecnologiasJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TecnologiasRepository extends JpaRepository<TecnologiasJpa,Integer> {

}
