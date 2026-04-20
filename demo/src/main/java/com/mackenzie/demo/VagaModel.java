package com.mackenzie.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "vaga")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VagaModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private Boolean ativo;
    private Long idEmpresa;
}
