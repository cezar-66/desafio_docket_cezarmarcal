package br.com.desafio_docket_cezarmarcal.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "certidoes")
public class Certidao {

    @Id
    @Column(name ="cert_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private String nome;

    @ManyToMany(mappedBy = "certidoes")
    private Set<Cartorio> cartorios;

    public Certidao() {}

    public Certidao(Long id, String nome, Set<Cartorio> cartorios) {
        this.id = id;
        this.nome = nome;
        this.cartorios = cartorios;
    }

    public Certidao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}

