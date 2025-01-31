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
@Table(name = "br_uf_2020")
public class Estado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "cd_uf")
    private String codigo;
    @Column(name = "nm_uf") 
    private String nome;
    @Column(name = "sigla_uf") 
    private String sigla; 
    @Column(name = "nm_regiao") 
    private String regiao; 
    @Column(name = "geom")
    private Geometry geometria;
}
