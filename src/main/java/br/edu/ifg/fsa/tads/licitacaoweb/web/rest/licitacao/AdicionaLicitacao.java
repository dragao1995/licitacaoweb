package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.licitacao;

import br.edu.ifg.fsa.tads.licitacaoweb.service.LicitacaoService;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.LicitacaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.AccountResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.validation.Valid;

@RestController
@Scope("prototype")
@RequestMapping("/api/adicionaLicitacao")
public class AdicionaLicitacao {

    @Autowired
    private LicitacaoService adesao;
    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public void adicionarLicitacao(@Valid LicitacaoDTO licitacao, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {

        }
        //adesao.adicionarAdesao(licitacao);
    }

    //Busca Licitação pelo Serviço do governo
    //IFG - codigo - 26208
    //IFG - nome - CENTRO FED. DE EDUCACAO TECNOLOGICA DE GOIAS
    //URL para ver como usar API http://compras.dados.gov.br/docs/home.html
    //Olhar adicionarLicitacao.controller - tem comentarios sobre como usar
    @RequestMapping(value="/buscarLicitacao",method = RequestMethod.GET)
    public String buscarLicitacao(){
        //Explica pq estou usando ele http://www.universidadejava.com.br/materiais/webservice-rest-jsf/
        Client c = Client.create();
        //url generica sobre IF
        //http://compras.dados.gov.br/licitacoes/doc/orgao/26208.json
        //url sobre todos os IF dentro
        //http://compras.dados.gov.br/licitacoes/v1/uasgs.json?id_orgao=26208
        WebResource wr = c.resource("http://compras.dados.gov.br/licitacoes/doc/orgao/26208.json");
        return wr.get(String.class);
    }
}
