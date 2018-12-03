package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.atualizarDados;

import br.edu.ifg.fsa.tads.licitacaoweb.service.AtualizarDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;

@RestController
@Scope("prototype")
@RequestMapping("/api/atualizarDados")
public class AtualizarDadosAPI {

    @Autowired
    AtualizarDadosService atualizarDadosService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void atualizarDados() throws UnsupportedEncodingException, JAXBException {
        atualizarDadosService.atualizarDados();
    }
}
