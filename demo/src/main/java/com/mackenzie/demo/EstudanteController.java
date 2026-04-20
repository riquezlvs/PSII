package com.mackenzie.demo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteRepository estudanteRepository;

    @GetMapping
    public Iterable<EstudanteModel> listar() { return estudanteRepository.findAll(); }

    @PostMapping
    public EstudanteModel criar(@RequestBody EstudanteModel estudante) {
        return estudanteRepository.save(estudante);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizar(@PathVariable Long id, @RequestBody EstudanteModel atualizado) {
        Optional<EstudanteModel> estudanteEncontrado = estudanteRepository.findById(id);
        if(estudanteEncontrado.isEmpty()) return null;
        EstudanteModel e = estudanteEncontrado.get();
        e.setNome(atualizado.getNome());
        e.setEmail(atualizado.getEmail());
        e.setNascimento(atualizado.getNascimento());
        e.setAnoIngresso(atualizado.getAnoIngresso());
        return estudanteRepository.save(e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estudanteRepository.deleteById(id);
    }
}