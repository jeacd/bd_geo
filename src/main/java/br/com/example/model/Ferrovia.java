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
@Table(name = "ferrovias_2014")
public class Ferrovia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "objectid")
    private Integer objectid;
    @Column(name = "ferrovia")
    private String rota;
    @Column(name = "operadora")
    private String operadora;
    @Column(name = "codpvnsimp")
    private String codpvnsimp;
    @Column(name = "cod_pvn")
    private String cod_pvn;
    @Column(name = "geom")
    private Geometry geometria;
}
