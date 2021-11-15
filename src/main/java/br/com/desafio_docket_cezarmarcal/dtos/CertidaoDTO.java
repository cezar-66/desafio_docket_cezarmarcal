package br.com.desafio_docket_cezarmarcal.dtos;

import lombok.Data;

@Data
public class CertidaoDTO {
    private Long id;
    private String nome;

    public CertidaoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CertidaoDTO(){}
}
