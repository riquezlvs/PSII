package com.mackenzie.demo;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping
    public Iterable<EmpresaModel> listar() { return empresaRepository.findAll(); }

    @PostMapping
    public EmpresaModel criar(@RequestBody EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    @PutMapping("/{id}")
    public EmpresaModel atualizar(@PathVariable Long id, @RequestBody EmpresaModel atualizado) {
        Optional<EmpresaModel> empresaEncontrada = empresaRepository.findById(id);
        if(empresaEncontrada.isEmpty()) return null;
        EmpresaModel e = empresaEncontrada.get();
        e.setNome(atualizado.getNome());
        e.setCnpj(atualizado.getCnpj());
        e.setEmailContato(atualizado.getEmailContato());
        return empresaRepository.save(e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresaRepository.deleteById(id);
    }
}