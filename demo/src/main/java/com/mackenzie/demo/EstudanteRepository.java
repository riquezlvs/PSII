package com.mackenzie.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstudanteRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String nascimento;
    private int anoIngresso;  
}
