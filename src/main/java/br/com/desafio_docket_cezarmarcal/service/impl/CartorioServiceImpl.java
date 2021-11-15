package br.com.desafio_docket_cezarmarcal.service.impl;


import br.com.desafio_docket_cezarmarcal.model.Cartorio;
import br.com.desafio_docket_cezarmarcal.repository.ICartorioRepository;
import br.com.desafio_docket_cezarmarcal.service.ICartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartorioServiceImpl implements ICartorioService {

    @Autowired
    private ICartorioRepository cartorioRepository;

    @Override
    public Set<Cartorio> getAll(){
        Set<Cartorio> cartorioSet = new HashSet<>();
        cartorioRepository.findAll().iterator().forEachRemaining(cartorioSet::add);
        return cartorioSet;
    }


    @Override
    public Cartorio findById(Long cartorioId){
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(cartorioId);

        if (!cartorioOptional.isPresent()) {
            throw new RuntimeException("Cartório não encontrado!");
        }
        return cartorioOptional.get();
    }


    @Override
    public void update(Long cartorioId, Cartorio cartorioDetails){
        Cartorio currentCartorio = findById(cartorioId);
        currentCartorio.setNome(cartorioDetails.getNome());
        currentCartorio.setEndereco(cartorioDetails.getEndereco());
        currentCartorio.setCertidoes(cartorioDetails.getCertidoes());

        cartorioRepository.save(currentCartorio);
    }


    @Override
    public void delete(Long cartorioId){
        cartorioRepository.deleteById(cartorioId);
    }


    @Override
    public Long create(Cartorio cartorioDetails){
        cartorioRepository.save(cartorioDetails);
        return cartorioDetails.getId();
    }
}
