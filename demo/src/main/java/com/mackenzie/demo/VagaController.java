package com.mackenzie.demo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    @Autowired
    VagaRepository vagaRepository;

    @GetMapping
    public Iterable<VagaModel> listar() { return vagaRepository.findAll(); }

    @PostMapping
    public VagaModel criar(@RequestBody VagaModel vaga) {
        return vagaRepository.save(vaga);
    }

    @PutMapping("/{id}")
    public VagaModel atualizar(@PathVariable Long id, @RequestBody VagaModel atualizado) {
        Optional<VagaModel> vagaEncontrada = vagaRepository.findById(id);
        if(vagaEncontrada.isEmpty()) return null;
        VagaModel v = vagaEncontrada.get();
        v.setTitulo(atualizado.getTitulo());
        v.setDescricao(atualizado.getDescricao());
        v.setAtivo(atualizado.getAtivo());
        return vagaRepository.save(v);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        vagaRepository.deleteById(id);
    }
}