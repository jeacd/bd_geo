package br.com.example.controller;

import java.util.List;

import br.com.example.model.Porto;
import br.com.example.model.PortoVO;
import br.com.example.repository.PortoRepository;
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
@OpenAPIDefinition(info = @Info(title = "Portos API", version = "1.0", description = "Dados de Portos"))
public class PortoController {

    @Autowired
    private PortoRepository repository;

    @GetMapping("/portosNoMunicipio/{municipio}")
    public List<Porto> portosNoMunicipio(@PathVariable String municipio) {
        return repository.portosNoMunicipio(municipio);
    }


}
