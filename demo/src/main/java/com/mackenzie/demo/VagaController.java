package com.mackenzie.demo;

import com.mackenzie.demo.Vaga;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {
    private static List<Vaga> vagas = new ArrayList<>();

    static {
        vagas.add(new Vaga(1L, "Desenvolvedor Java", "Atuação em projetos backend...", "2025-10-01", true, 1L));
        vagas.add(new Vaga(2L, "Analista de Suporte Técnico", "Suporte a clientes...", "2025-09-27", true, 2L));
        vagas.add(new Vaga(3L, "Engenheiro de Software", "Desenvolvimento de sistemas...", "2025-10-03", false, 3L));
        vagas.add(new Vaga(4L, "Analista de Dados", "Conhecimentos de SQL e Python...", "2025-09-18", true, 4L));
        vagas.add(new Vaga(5L, "Designer Digital", "UX/UI e marketing...", "2025-09-30", false, 5L));
        vagas.add(new Vaga(6L, "Consultor de Projetos", "Treinamentos empresariais...", "2025-10-06", true, 1L));
        vagas.add(new Vaga(7L, "Programador Full Stack", "Frontend e backend...", "2025-10-04", true, 2L));
    }

    @GetMapping
    public List<Vaga> listar() { return vagas; }

    @PostMapping
    public Vaga criar(@RequestBody Vaga vaga) {
        vagas.add(vaga);
        return vaga;
    }

    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga atualizado) {
        for (Vaga v : vagas) {
            if (v.getId().equals(id)) {
                v.setTitulo(atualizado.getTitulo());
                v.setDescricao(atualizado.getDescricao());
                v.setAtivo(atualizado.getAtivo());
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Vaga vagaEncontrada = null;
        for (Vaga v : vagas) {
            if (v.getId().equals(id)) {
                vagaEncontrada = v;
                break;
            }
        }

        if (vagaEncontrada != null) {
            vagas.remove(vagaEncontrada);
        }
    }
}