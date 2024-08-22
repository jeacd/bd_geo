package br.com.example.repository;

import br.com.example.model.Ferrovia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FerroviaRepository extends JpaRepository<Ferrovia, Integer> {

    @Query(value = "select f from Ferrovia f, Municipio m where intersects(f.geometria, m.geometria) and m.nome = :municipio")
    public List<Ferrovia> ferroviasNoMunicipio(String municipio);

    @Query("select f from Ferrovia f join Rodovia r on intersects(f.geometria, r.geometria)")
    public List<Ferrovia> ferroviasERodovias();
}
