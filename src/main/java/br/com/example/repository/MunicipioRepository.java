/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Municipio;
import br.com.example.model.MunicipioVO;
import java.util.List;

import org.geolatte.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author caian
 */
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{
    
    @Query(value = "select new br.com.example.model.MunicipioVO(mb.codigo,mb.nome,mb.geometria) from Municipio ma, Municipio mb where touches(ma.geometria, mb.geometria) = true and ma.nome = :nome")
    List<MunicipioVO> listarMunicipiosVizinhos(String nome);
     
    @Query(value ="select distance(geography(ma.geometria), geography(mb.geometria)) from Municipio ma, Municipio mb where ma.nome = :municipioA  and   mb.nome = :municipioB")
    public Double distanciaEntreMunicipios(String municipioA, String municipioB);

    @Query("select area(m.geometria) from Municipio m where m.nome = :municipio")
    public Double areaM(String municipio);

    @Query(value = "select m from Municipio m join Estado e on contains(e.geometria, m.geometria) = true where e.nome = :estado") 
    public List<Municipio> municipiosEstado(String estado);
}
