package br.com.example.repository;

import br.com.example.model.Rodovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RodoviaRepository extends JpaRepository<Rodovia, Integer> {

   @Query(value = "select r from Rodovia r, Municipio m where intersects(r.geometria, m.geometria) and m.nome = :municipio")
   public List<Rodovia> rodoviasQuePassamPorMunicipio(String municipio);
   
   @Query(value = "select r from Rodovia r, Municipio m where within(r.geometria, m.geometria) and m.nome = :municipio")
   public List<Rodovia> rodoviasContidasEmMunicipio(String municipio);
}