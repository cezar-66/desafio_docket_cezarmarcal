package br.com.desafio_docket_cezarmarcal.service;

import br.com.desafio_docket_cezarmarcal.model.Cartorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface ICartorioService extends ICrudService<Cartorio, Long> {

    Set<Cartorio> getAll();

    void delete(Long cartorioId);

}