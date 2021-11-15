package br.com.desafio_docket_cezarmarcal.controller;

import br.com.desafio_docket_cezarmarcal.model.Cartorio;
import br.com.desafio_docket_cezarmarcal.model.Certidao;
import br.com.desafio_docket_cezarmarcal.service.ICartorioService;
import br.com.desafio_docket_cezarmarcal.service.ICertidaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class CartorioController {

    @Autowired
    private ICartorioService cartorioService;
    @Autowired
    private ICertidaoService certidaoService;


    @RequestMapping( path = "/cartorio/show/{id}")
    public String showSingleCartorio(@PathVariable("id") long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id);
        model.addAttribute("cartorio", cartorio);
        return "cartorios/showById";
    }


    @RequestMapping( path = "/cartorio/create")
    public String newCartorioForm(Model model) {
        model.addAttribute("cartorio", new Cartorio());
        Set<Certidao> certidoes = certidaoService.getAll();
        model.addAttribute("certidoes", certidoes);
        return "cartorios/new";
    }


    @RequestMapping(path = "/cartorio", method = RequestMethod.POST)
    public String saveNewCartorio(Cartorio cartorio) {
        long id = cartorioService.create(cartorio);
        return "redirect:/cartorios";
    }


    @GetMapping("/cartorio/{id}")
    public String editCartorioForm(@PathVariable("id") long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id);
        Set<Certidao> certidoes = certidaoService.getAll();

        model.addAttribute("allCertidoes", certidoes);
        model.addAttribute("cartorio", cartorio);
        return "cartorios/edit";
    }


    @GetMapping({"/cartorios"})
    public String showAllCartorios(Model model) {
        model.addAttribute("cartorios", cartorioService.getAll());
        model.addAttribute("certidoes", certidaoService.getAll());
        return "index";
    }


    @RequestMapping(path = "/cartorio/{id}", method = RequestMethod.POST)
    public String updateCartorio(@PathVariable("id") long id, Cartorio cartorio) {
        cartorioService.update(id, cartorio);
        return "redirect:/cartorios";    }


    @RequestMapping(path = "/cartorio/delete/{id}", method = RequestMethod.GET)
    public String deleteCartorio(@PathVariable("id") long id) {
        cartorioService.delete(id);
        return "redirect:/cartorios";
    }
}

