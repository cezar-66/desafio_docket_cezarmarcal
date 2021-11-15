package br.com.desafio_docket_cezarmarcal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    //É necessário estar logado para acessar a raiz do projeto
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index(){
        return "home/index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/authenticate")
    public String authenticate(){
        return "login";
    }
}