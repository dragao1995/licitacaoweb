package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.licitacao;

import br.edu.ifg.fsa.tads.licitacaoweb.service.LicitacaoService;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.LicitacaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MaterialDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.SolicitarDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("/api/licitacao")
public class LicitacaoAPI {

    @Autowired
    LicitacaoService licitacaoService;

    @RequestMapping(value = "/escolher", method = RequestMethod.POST)
    public Response listar(@Valid LicitacaoDTO filtro
    ) {

        OrderBy orderBy = new OrderBy(filtro.getCampo(), filtro.getOrdem());
        Response response;
        LazyResultVO<LicitacaoDTO> resultados;
        try {
            resultados = licitacaoService.listaPaginada(filtro.getPage(), filtro.getCount(), orderBy, filtro);
            response = Response.ok().entity(resultados).build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }

    @RequestMapping(value = "/solicitar", method = RequestMethod.POST)
    public Response solicitar(@Valid SolicitarDTO filtro) {


        Response response;
        try {
            String protocolo = licitacaoService.solicitar(filtro);
            response = Response.ok().entity(protocolo).build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }
}
