package br.com.desafio_docket_cezarmarcal.model;

/*
 @Autor: Cezar Marçal
 Data: 15/11/2021
 * Obs: Não é recomendado utilizar a anotação @Data para gerar os getters and setters nessa classe.
 * Como temos um mapeamento de Set<Certidao> ao fazer um GetAll para recuperar essas informações
 * O método constrói uma string de retorno alternadamente de Cartorio
 * que fazem referência uma à outra, o que produz um processo infinito.
 * */

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartorios")
public class Cartorio {

    @Id
    @Column(name = "cartorio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @Column
    private String endereco;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cartorio_certidao",
            joinColumns = { @JoinColumn(name = "cartorio_id") },
            inverseJoinColumns = { @JoinColumn(name = "certidao_id") })
    private Set<Certidao> certidoes = new HashSet<>();

    public Cartorio(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Certidao> getCertidoes() {
        return certidoes;
    }

    public void setCertidoes(Set<Certidao> certidoes) {
        this.certidoes = certidoes;
    }
}
