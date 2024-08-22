package br.com.example.controller;

import br.com.example.model.Armazem;
import br.com.example.repository.ArmazemRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Armazéns API", version = "1.0", description = "Dados de Armazéns"))
public class ArmazemController {

    @Autowired
    private ArmazemRepository repository;

    @GetMapping("/armazensNoMunicipio/{municipio}")
    public List<Armazem> armazensNoMunicipio(@PathVariable String municipio) {
        return repository.armazensNoMunicipio(municipio);
    }

    @GetMapping("/armazensNoEstado/{estado}")
    public List<Armazem> armazensNoEstado(@PathVariable String estado) {
        return repository.armazensNoEstado(estado);
    }

}
