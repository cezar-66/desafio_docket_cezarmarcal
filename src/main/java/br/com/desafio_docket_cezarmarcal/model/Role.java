package br.com.desafio_docket_cezarmarcal.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_role")
    @NotNull
    private String nomeRole;

    @ManyToMany(mappedBy = "roles")
    private List<Operador> listOperador;

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}