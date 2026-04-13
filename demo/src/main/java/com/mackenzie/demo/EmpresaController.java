package com.mackenzie.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private static List<Empresa> empresas = new ArrayList<>();

    static {
        empresas.add(new Empresa(1L, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2L, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3L, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4L, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5L, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping
    public List<Empresa> listar() { return empresas; }

    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        empresas.add(empresa);
        return empresa;
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa atualizado) {
        for (Empresa e : empresas) {
            if (e.getId().equals(id)) {
                e.setNome(atualizado.getNome());
                e.setCnpj(atualizado.getCnpj());
                e.setEmailContato(atualizado.getEmailContato());
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Empresa empresaEncontrada = null;
        for (Empresa e : empresas) {
            if (e.getId().equals(id)) {
                empresaEncontrada = e;
                break; // Para o loop assim que encontrar
            }
        }
        
        if (empresaEncontrada != null) {
            empresas.remove(empresaEncontrada);
        }
    }
}