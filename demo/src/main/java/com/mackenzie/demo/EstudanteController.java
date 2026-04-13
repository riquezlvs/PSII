package com.mackenzie.demo;

import com.mackenzie.demo.Estudante;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    private static List<Estudante> estudantes = new ArrayList<>();

    static {
        estudantes.add(new Estudante(1L, "Ana Paula Souza", "ana.souza@email.com", "2002-03-15", 2020));
        estudantes.add(new Estudante(2L, "Carlos Henrique Lima", "carlos.lima@email.com", "2001-10-22", 2019));
        estudantes.add(new Estudante(3L, "Fernanda Oliveira", "fernanda.oliveira@email.com", "2003-07-05", 2021));
        estudantes.add(new Estudante(4L, "Lucas Pereira", "lucas.pereira@email.com", "2002-04-11", 2020));
        estudantes.add(new Estudante(5L, "Gabriela Martins", "gabriela.martins@email.com", "2001-12-25", 2019));
        estudantes.add(new Estudante(6L, "Rafael Costa", "rafael.costa@email.com", "2000-09-13", 2018));
        estudantes.add(new Estudante(7L, "Juliana Silva", "juliana.silva@email.com", "2002-06-18", 2020));
        estudantes.add(new Estudante(8L, "Marcos Vinícius", "marcos.vinicius@email.com", "2003-01-30", 2021));
        estudantes.add(new Estudante(9L, "Camila Azevedo", "camila.azevedo@email.com", "2001-11-08", 2019));
        estudantes.add(new Estudante(10L, "Felipe Cardoso", "felipe.cardoso@email.com", "2000-08-27", 2018));
    }

    @GetMapping
    public List<Estudante> listar() { return estudantes; }

    @PostMapping
    public Estudante criar(@RequestBody Estudante estudante) {
        estudantes.add(estudante);
        return estudante;
    }

    @PutMapping("/{id}")
    public Estudante atualizar(@PathVariable Long id, @RequestBody Estudante atualizado) {
        for (Estudante e : estudantes) {
            if (e.getId().equals(id)) {
                e.setNome(atualizado.getNome());
                e.setEmail(atualizado.getEmail());
                e.setNascimento(atualizado.getNascimento());
                e.setAnoIngresso(atualizado.getAnoIngresso());
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Estudante estudanteEncontrado = null;
        for (Estudante e : estudantes) {
            if (e.getId().equals(id)) {
                estudanteEncontrado = e;
                break;
            }
        }

        if (estudanteEncontrado != null) {
            estudantes.remove(estudanteEncontrado);
        }
    }
}