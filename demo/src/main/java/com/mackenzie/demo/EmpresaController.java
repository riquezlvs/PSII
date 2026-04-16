package com.mackenzie.demo;

import java.lang.foreign.Linker.Option;
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
        if (empresaEncontrada.isPresent()) {
            EmpresaModel empresa = empresaEncontrada.get();
            empresa.setNome(atualizado.getNome());
            empresa.setCnpj(atualizado.getCnpj());
            empresa.setEmailContato(atualizado.getEmailContato());
            return empresaRepository.save(empresa);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        EmpresaModel empresaEncontrada = null;
        for (EmpresaModel e : empresaRepository.findAll()) {
            if (e.getId().equals(id)) {
                empresaEncontrada = e;
                break; 
            }
        }
        
        if (empresaEncontrada != null) {
            empresaRepository.delete(empresaEncontrada);
        }
    }
}