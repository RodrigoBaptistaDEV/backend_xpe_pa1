package com.globally.mentor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mentores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name= "descricao_curta", nullable = false)
    private String descricaoCurta;

    @Column(name= "descricao_longa", nullable = false)
    private String descricaoLonga;
}
