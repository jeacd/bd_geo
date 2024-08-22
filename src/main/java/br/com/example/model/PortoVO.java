/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.example.model;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.locationtech.jts.geom.Geometry;



/**
 *
 * @author caian
 */
@Data
@AllArgsConstructor
public class PortoVO implements Serializable{
    private double ID;
    private String estado;
    private String regiao;
    private String municipio;
    private Geometry geometria;
}
