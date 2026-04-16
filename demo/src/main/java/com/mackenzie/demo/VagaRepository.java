package com.mackenzie.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vaga")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VagaRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private Boolean ativo;
    private Long idEmpresa;
}
