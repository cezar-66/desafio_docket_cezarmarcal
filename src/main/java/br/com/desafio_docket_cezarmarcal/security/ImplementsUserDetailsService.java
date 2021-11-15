package br.com.desafio_docket_cezarmarcal.security;

import br.com.desafio_docket_cezarmarcal.model.Operador;
import br.com.desafio_docket_cezarmarcal.repository.IOperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private IOperadorRepository operadorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operador operador = operadorRepository.findByUsername(username);
        if (operador == null) {
            throw new UsernameNotFoundException("Operador não encontrado");
        }
        return new User(
                operador.getUsername(),
                operador.getPassword(),
                true,
                true,
                true,
                true,
                operador.getAuthorities());
    }
}
