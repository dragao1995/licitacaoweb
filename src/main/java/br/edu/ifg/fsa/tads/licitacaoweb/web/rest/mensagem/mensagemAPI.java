package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.mensagem;

import br.edu.ifg.fsa.tads.licitacaoweb.service.MensagemService;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.FiltroRequisicaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MensagemDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@RestController
@Scope("prototype")
@RequestMapping("/api/mensagens")
public class mensagemAPI {

    @Autowired
    MensagemService mensagemService;

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public Response analisar(@Valid FiltroRequisicaoDTO filtro
    ) {

        OrderBy orderBy = new OrderBy(filtro.getCampo(), filtro.getOrdem());
        Response response;
        LazyResultVO<MensagemDTO> resultados;
        try {
            resultados = mensagemService.listaPaginada(filtro.getPage(), filtro.getCount(), orderBy, filtro, false);
            response = Response.ok().entity(resultados).build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }

    @RequestMapping(value = "/resposta", method = RequestMethod.POST)
    public Response reposta(@Valid FiltroRequisicaoDTO filtro
    ) {

        OrderBy orderBy = new OrderBy(filtro.getCampo(), filtro.getOrdem());
        Response response;
        LazyResultVO<MensagemDTO> resultados;
        try {
            resultados = mensagemService.listaPaginada(filtro.getPage(), filtro.getCount(), orderBy, filtro, true);
            response = Response.ok().entity(resultados).build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }


    @RequestMapping(value = "/responderAceito", method = RequestMethod.POST)
    public Response responderAceito(@Valid FiltroRequisicaoDTO filtro
    ) {

        Response response;
        try {
            mensagemService.responder(filtro.getId(), filtro.getObservacao(), true);
            response = Response.ok().build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }

    @RequestMapping(value = "/responderRejeitado", method = RequestMethod.POST)
    public Response responderRejeitado(@Valid FiltroRequisicaoDTO filtro
    ) {

        Response response;
        try {
            mensagemService.responder(filtro.getId(), filtro.getObservacao(), false);
            response = Response.ok().build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }
}
