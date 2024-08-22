package br.com.example.model;


import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.locationtech.jts.geom.Geometry;

@Data
@Entity
@Table(name = "aeroportos_2014")
public class Aeroporto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "objectid_1")
    private double ID;
    @Column(name = "municdv")
    private String municdv;
    @Column(name = "uf")
    private String ufCode;
    @Column(name = "nome_uf")
    private String estado;
    @Column(name = "nome_regia")
    private String regiao;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "pax2010")
    private double pax; 
    @Column(name = "internacio")
    private double internacio; 
    @Column(name = "geom")
    private Geometry geometria;
  
}
