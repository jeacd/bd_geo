package br.com.example.repository;

import br.com.example.model.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArmazemRepository extends JpaRepository<Armazem, Integer> {

    @Query(value = "select a from Armazem a, Municipio m where within(a.geometria, m.geometria) and m.nome = :municipio")
    public List<Armazem> armazensNoMunicipio(String municipio);

    @Query(value = "select a from Armazem a, Estado e where contains(e.geometria, a.geometria) and e.nome = :estado")
    public List<Armazem> armazensNoEstado(String estado);
}
