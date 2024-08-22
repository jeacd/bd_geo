package br.com.example.controller;

import br.com.example.model.Ferrovia;
import br.com.example.repository.FerroviaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Ferrovias API", version = "1.0", description = "Dados de Ferrovias"))
public class FerroviaController {

    @Autowired
    private FerroviaRepository repository;

    @GetMapping("/ferroviasNoMunicipio/{municipio}")
    public List<Ferrovia> ferroviasNoMunicipio(@PathVariable String municipio) {
        return repository.ferroviasNoMunicipio(municipio);
    }

    @GetMapping("/ferroviasERodovias")
    public List<Ferrovia> ferroviasERodovias() {
        return repository.ferroviasERodovias();
    }

}
