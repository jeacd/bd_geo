package br.com.example.controller;

import java.util.List;
import br.com.example.model.Aeroporto;
import br.com.example.model.AeroportoVO;
import br.com.example.repository.AeroportoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.locationtech.jts.geom.Geometry;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Aeroportos API", version = "1.0", description = "Dados de Aeroportos"))
public class AeroportoController {
    
    @Autowired
    private AeroportoRepository repository;

    @GetMapping("/distanciaEntreAeroportos/{aeroportoA}/{aeroportoB}")
    public Double distanciaEntreAeroportos(@PathVariable String aeroportoA, @PathVariable String aeroportoB) {
        return repository.distanciaEntreAeroportos(aeroportoA, aeroportoB);
    }

    @GetMapping("/aeroportosEmMunicipio/{municipio}")
    public List<Aeroporto> aeroportosEmMunicipio(@PathVariable String municipio) {
        return repository.aeroportosEmMunicipio(municipio);
    }
}
