package com.mackenzie.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estudante {
    private Long id;
    private String nome;
    private String email;
    private String nascimento;
    private int anoIngresso;    
}