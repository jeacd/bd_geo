package br.com.example.controller;

import java.util.List;
import br.com.example.repository.RodoviaRepository;
import br.com.example.model.Rodovia;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Rodovias API", version = "1.0", description = "Dados de Rodovias"))
public class RodoviaController {

    @Autowired
    private RodoviaRepository repository;

    @GetMapping("/rodoviasQuePassamPorMunicipio/{municipio}")
    public List<Rodovia> rodoviasQuePassamPorMunicipio(@PathVariable String municipio) {
        return repository.rodoviasQuePassamPorMunicipio(municipio);
    }

    @GetMapping("/rodoviasContidasEmMunicipio/{municipio}")
    public List<Rodovia> rodoviasContidasEmMunicipio(@PathVariable String municipio) {
        return repository.rodoviasContidasEmMunicipio(municipio);
    }
}