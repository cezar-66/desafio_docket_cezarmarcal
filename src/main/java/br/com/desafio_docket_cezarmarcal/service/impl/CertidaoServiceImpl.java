package br.com.desafio_docket_cezarmarcal.service.impl;

import br.com.desafio_docket_cezarmarcal.dtos.CertidaoDTO;
import br.com.desafio_docket_cezarmarcal.model.Certidao;
import br.com.desafio_docket_cezarmarcal.repository.ICertidaoRepository;
import br.com.desafio_docket_cezarmarcal.service.ICertidaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CertidaoServiceImpl implements ICertidaoService{

    @Autowired
    private ICertidaoRepository certidaoRepository;

    //URL API Docket
    private final String url = "https://docketdesafiobackend.herokuapp.com/api/v1/certidoes";

    @Override

    //Add todas as certidoes já cadastradas no cartorio, e acrecenta certidões emitidas pela Docket
    public Set<Certidao> getAll(){
        Set<Certidao> certidaoSet = new HashSet<>();
        certidaoRepository.findAll().iterator().forEachRemaining(certidaoSet::add);

        List<CertidaoDTO> certidoesApiDocket = consumerAPIDocket();

        for(CertidaoDTO certidaoDTO: certidoesApiDocket){
            Optional<Certidao> certidaoJaCadastrada = certidaoRepository.findById(certidaoDTO.getId());

            //Verifica se todas as certidões emitidas pela Docket já estão cadastradas no sistema
            //Caso não esteja, cadastra o novo registro
            if(certidaoJaCadastrada.isEmpty()){
                Certidao certidao = new Certidao();
                certidao.setId(certidaoDTO.getId());
                certidao.setNome(certidaoDTO.getNome());
                certidaoRepository.save(certidao);

                certidaoRepository.findAll().iterator().forEachRemaining(certidaoSet::add);
            }
        }

        return certidaoSet;
    }

    @Override
    public Certidao findById(Long certId){
        Optional<Certidao> certidaoOptional = certidaoRepository.findById(certId);

        if (!certidaoOptional.isPresent()) {
            throw new RuntimeException("Certidão não encontrada!");
        }
        return certidaoOptional.get();
    }

    @Override
    public void delete(Long certId){
        certidaoRepository.deleteById(certId);
    }


    @Override
    public Long create(Certidao certidaoDetails){
        certidaoRepository.save(certidaoDetails);
        return certidaoDetails.getId();
    }

    @Override
    public void update(Long certId, Certidao certidaoDetails){
        Certidao currentCert = findById(certId);
        currentCert.setNome(certidaoDetails.getNome());

        certidaoRepository.save(currentCert);
    }


    //Busca dados da API fornecido pela Docket e retorna uma lista das infomações encontradas
    public List<CertidaoDTO> consumerAPIDocket(){

        List<CertidaoDTO> certidaoDTOList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<CertidaoDTO[]> response =
                    restTemplate.getForEntity(url, CertidaoDTO[].class);

            //Adiciona na variavel "certidaoDTOList" todas as informações que foram retornadas da API
            //E retorna uma lista de CertidaoDTO
            for(CertidaoDTO certidaoDTO: response.getBody()){
                certidaoDTOList.add(new CertidaoDTO(certidaoDTO.getId(), certidaoDTO.getNome()));
            }

        }catch (Exception e){
            throw e;
        }
        return certidaoDTOList;
    }

}
