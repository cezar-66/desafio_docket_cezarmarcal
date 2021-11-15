package br.com.desafio_docket_cezarmarcal.service;


import br.com.desafio_docket_cezarmarcal.dtos.CertidaoDTO;
import br.com.desafio_docket_cezarmarcal.model.Certidao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ICertidaoService extends ICrudService<Certidao, Long> {

    Set<Certidao> getAll();

    Certidao findById(Long certId);

    Long create(Certidao certidaoDetails);

    void update(Long certId, Certidao certidaoDetails);

    void delete(Long certId);

    List<CertidaoDTO> consumerAPIDocket();
}

