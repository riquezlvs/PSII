package com.mackenzie.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vaga {
    private Long id;
    private String titulo;
    private String descricao;
    private String publicacao;
    private Boolean ativo;
    private Long idEmpresa;
}