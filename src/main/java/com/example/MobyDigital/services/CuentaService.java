package com.example.MobyDigital.services;

import com.example.MobyDigital.entities.Candidato;
import com.example.MobyDigital.entities.Tecnologias;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CuentaService {
    Connection connection = getConnection();

    public Connection getConnection() {

        String url = "jdbc:mysql://127.0.0.1:3306/MobyDigital?useUnicode=true&characterEncoding=UTF-8&user=root&password=Nano005a$";

        try {
            connection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("Conexión Ok");
        } else {
            System.out.println("Conexión Null");
        }
        return connection;
    }


    // Crud Candidato----------------------------------------------------------------------------------------
    // Crud Candidato----------------------------------------------------------------------------------------
    // Crud Candidato----------------------------------------------------------------------------------------
    public void crearCandidato(String nombre, String apellido, String docTipo, Integer numeroDoc, java.sql.Date fechaNac) {

    String crearCandidato = "insert into Candidato (Nombre, Apellido, DocTipo, NumeroDoc, FechaNac) values (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(crearCandidato);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, docTipo);
            ps.setInt(4, numeroDoc);
            ps.setDate(5, fechaNac);
            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Candidato> buscarPorId(int id) {
        String select = "select * from Candidato where IdCandidato=?";

        List<Candidato> lstCandidato = new ArrayList<>();
        Candidato cdto = new Candidato();

        try {
            PreparedStatement ps = connection.prepareStatement(select);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString(1);
                String apellido = rs.getString(2);
                String tipo = rs.getString(3);
                int docnum = rs.getInt(4);
                Date fechanac = rs.getDate(5);
                cdto.setNombre(nombre);
                cdto.setApellido(apellido);
                cdto.setTipo(tipo);
                cdto.setDocnum(docnum);
                cdto.setFechaNac(fechanac);
                lstCandidato.add(cdto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstCandidato;
    }

    public void actualizar(String nombre, String apellido, String docTipo, int numeroDoc, java.sql.Date fechaNac, int IdCandidato) {

        String actualizar = "update Candidato set Nombre=?, Apellido=?, DocTipo=?, NumeroDoc=?, FechaNac=? where IdCandidato=?;";

        try {

            PreparedStatement ps = connection.prepareStatement(actualizar);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, docTipo);
            ps.setInt(4, numeroDoc);
            ps.setDate(5, fechaNac);
            ps.setInt(6, IdCandidato);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrar(int id) {
        String borrar = "delete from Candidato where IdCandidato=?";
        try {
            PreparedStatement ps = connection.prepareStatement(borrar);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //CrudTecnologias---------------------------------------------------------------------------------------------
    //CrudTecnologias---------------------------------------------------------------------------------------------
    //CrudTecnologias---------------------------------------------------------------------------------------------


    public String crearTecnologia(String tecnologia, int años) {

        String altaTecnologia = "insert into Tecnologias (Tecnologia, Version) values (?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(altaTecnologia);
            ps.setString(1, tecnologia);
            ps.setInt(2, años);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Operacion completada";
    }

    public List<Tecnologias> buscarTecnologia(int id) {
        String buscarTecnologia = "select * from Tecnologias where idTecnologia=?";
        List<Tecnologias> lista = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(buscarTecnologia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tecnologias tecnologias = new Tecnologias();

                String Tecnologia = rs.getString("Version");
                int idTec = rs.getInt("idTecnologia");
                tecnologias.setTecnologia(Tecnologia);
                tecnologias.setVersion(idTec);
                lista.add(tecnologias);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizarTecnologia(String nombre, int version, int id) {
        String actualizarTecnologia = "update Tecnologia=?, Version=? from Tecnologias where idTecnologia=?;";
        try { PreparedStatement ps= connection.prepareStatement(actualizarTecnologia);
              ps.setString(1,nombre);
              ps.setInt(2,version);
              ps.setInt(3, id);
              ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void borrarTecnologia(int id){
        String borrarTecnologia=" detele from Tecnologias where idTecnologia=?;";

        try{
            PreparedStatement ps = connection.prepareStatement(borrarTecnologia);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //CrudCandidatoxTecnologia------------------------------------------------------------------------------------------
    //CrudCandidatoxTecnologia------------------------------------------------------------------------------------------
    //CrudCandidatoxTecnologia------------------------------------------------------------------------------------------

    public void crearCandxTec(int idCandidato, int IdTecnologia, int años_Exp)
    {

     String crearCxT="insert into CandidatoxTecnologia( idCandidato, IdTecnologia,Años_Experiencia) values(?,?,?);";

     try {
         PreparedStatement ps= connection.prepareStatement(crearCxT);
         ps.setInt(1,idCandidato);
         ps.setInt(2,IdTecnologia);
         ps.setInt(3,años_Exp);
         ps.executeUpdate();
     } catch (SQLException o) {
         o.printStackTrace();
       }
     }

     public List<Candidato> buscarCandidatoxTecn(){
        String buscar="select Candidato.idCandidato, Nombre, Apellido, DocTipo, NumeroDoc, Tecnologia,Version from CandidatoxTecnologia inner join Candidato on Candidato.IdCandidato = CandidatoxTecnologia.idCandidato\n" +
                "inner join Tecnologias on Tecnologias.idTecnologia = CandidatoxTecnologia.IdTecnologia;";
         Candidato candidato=new Candidato();
         Tecnologias tecnologias=new Tecnologias();
         List<Candidato> listaCand= new ArrayList<>();
         try { PreparedStatement ps = connection.prepareStatement(buscar);
               ps.executeQuery();
               ResultSet rs= ps.executeQuery();
               while (rs.next()){

                   String nombre = rs.getString("Nombre");
                   String apellido = rs.getString("Apellido");
                   String doctipo = rs.getString("DocTipo");
                   int numdoc = rs.getInt("NumeroDoc");
                   String tecnologia = rs.getString("Tecnologia");
                   int version = rs.getInt("Version");
                   candidato.setNombre(nombre);
                   candidato.setApellido(apellido);
                   candidato.setTipo(doctipo);
                   candidato.setDocnum(numdoc);
                   tecnologias.setTecnologia(tecnologia);
                   tecnologias.setVersion(version);
                   candidato.setTec(tecnologias);
                   listaCand.add(candidato);
               }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return listaCand;
     }

    public List<Candidato> buscarCandidatoxTecnologia(String tecn){

        String buscar="select Candidato.idCandidato, Nombre, Apellido, DocTipo, NumeroDoc," +
                " Tecnologia,Version from CandidatoxTecnologia" +
                " inner join Candidato on Candidato.IdCandidato = CandidatoxTecnologia.idCandidato\n" +
                "inner join Tecnologias on Tecnologias.idTecnologia = CandidatoxTecnologia.IdTecnologia " +
                "where Tecnologias.Tecnologia=?;";
        Candidato candidato=new Candidato();
        Tecnologias tecnologia= new Tecnologias();
        List<Candidato> candidatoList=new ArrayList<>();

        try {
            PreparedStatement ps= connection.prepareStatement(buscar);
             ps.setString(1,tecn);
             ResultSet rs= ps.executeQuery();
             while(rs.next()){
                 String nombre = rs.getString("Nombre");
                 String apellido = rs.getString("Apellido");
                 String doctipo = rs.getString("DocTipo");
                 int numdoc = rs.getInt("NumeroDoc");
                 String tecnologias = rs.getString("Tecnologia");
                 int version = rs.getInt("Version");
                 candidato.setNombre(nombre);
                 candidato.setApellido(apellido);
                 candidato.setTipo(doctipo);
                 candidato.setDocnum(numdoc);
                 tecnologia.setTecnologia(tecnologias);
                 tecnologia.setVersion(version);
                 candidato.setTec(tecnologia);
                 candidatoList.add(candidato);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatoList;
    }


   }

