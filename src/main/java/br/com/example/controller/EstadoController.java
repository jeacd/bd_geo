package br.com.example.controller;

import java.util.List;
import br.com.example.repository.EstadoRepository;
import br.com.example.model.Estado;
import br.com.example.model.Municipio;
import br.com.example.model.MunicipioVO;
// import br.com.example.model.EstadoVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.geolatte.geom.Geometry;
// import org.geolatte.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Estados API", version = "1.0", description = "Dados de Estados"))
public class EstadoController {
    
    @Autowired
    private EstadoRepository repository;
    
    @GetMapping("/distanciaEntreEstados/{estadoA}/{estadoB}")
    public Double distanciaEntreEstados (@PathVariable String estadoA, @PathVariable String estadoB){ 
        double result = repository.distanciaEntreEstados(estadoA, estadoB);
        return result;
    }

    @GetMapping("/estadosVizinhos/{nome}")
    public List<Estado> estadosVizinhos(@PathVariable String nome){
        List<Estado> result = repository.listarEstadosVizinhos(nome);
        return result;
    }
}