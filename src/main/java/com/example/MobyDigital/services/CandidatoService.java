package com.example.MobyDigital.services;


import com.example.MobyDigital.Interfaz.CandidatoRepository;
import com.example.MobyDigital.Interfaz.TecnologiasRepository;
import com.example.MobyDigital.entities.CandidatoJpa;
import com.example.MobyDigital.entities.TecnologiasJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private TecnologiasRepository tecnologiasRepository;

    public Optional<CandidatoJpa> read(Integer IdCandidato){

        Optional<CandidatoJpa> candidatoJpaOptional= candidatoRepository.findById(IdCandidato);
       /* if (optional.isPresent()) {
            System.out.println(optional.get());

        } else{
            System.out.println("Categoria no encontrada");
        }*/

        //return repo.findById(IdCandidato);Optional<CandidatoJpa>

        return candidatoJpaOptional;
    }

    public List<CandidatoJpa> crearCandidatoJpa(String Nombre,String Apellido, String DocTipo,
                                                Integer NumeroDoc, java.sql.Date FechaNac ){

        CandidatoJpa candidatoJpa= new CandidatoJpa();
        List<CandidatoJpa> crearCandidato=new ArrayList<>();
        candidatoJpa.setNombre(Nombre);
        candidatoJpa.setApellido(Apellido);
        candidatoJpa.setDocTipo(DocTipo);
        candidatoJpa.setNumeroDoc(NumeroDoc);
        candidatoJpa.setFechaNac(FechaNac);
        crearCandidato.add(candidatoJpa);
        candidatoRepository.save(candidatoJpa);
    return crearCandidato;
    }

    public TecnologiasJpa crearTecnologia(String tecnologia, int version){

        TecnologiasJpa tecno= new TecnologiasJpa();
        tecno.setTecnologia(tecnologia);
        tecno.setVersion(version);

        return  tecnologiasRepository.save(tecno);
    }

    public List<CandidatoJpa> select(){

        return candidatoRepository.findAllByNombre("Lucas");

    }

}
