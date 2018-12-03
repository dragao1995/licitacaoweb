package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.AtasRecurso;

import br.edu.ifg.fsa.tads.licitacaoweb.service.Atas.AtasService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("/api/atas")
public class Atas {

    @Autowired
    private AtasService service;

    @RequestMapping(value="/pesquisar",method = RequestMethod.GET)
    public String buscarLicitacao(){
        return service.buscarLicitacao();

    }
}
