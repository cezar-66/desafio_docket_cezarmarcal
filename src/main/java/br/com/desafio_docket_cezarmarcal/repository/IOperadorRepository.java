package br.com.desafio_docket_cezarmarcal.repository;

import br.com.desafio_docket_cezarmarcal.model.Certidao;
import br.com.desafio_docket_cezarmarcal.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperadorRepository extends JpaRepository<Operador, Long> {

    Operador findByUsername(String login);
}
