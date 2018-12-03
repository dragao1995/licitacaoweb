package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.ServicoLicitacao;

import br.edu.ifg.fsa.tads.licitacaoweb.service.MaterialService;
import br.edu.ifg.fsa.tads.licitacaoweb.service.ServicoService;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MaterialDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.ServicoDTO;
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
@RequestMapping("/api/servico")
public class ServicoAPI {

    @Autowired
    ServicoService servicoService;

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public Response listar(@Valid ServicoDTO filtro
    ) {

        OrderBy orderBy = new OrderBy(filtro.getCampo(), filtro.getOrdem());
        Response response;
        LazyResultVO<ServicoDTO> resultados;
        try {
            resultados = servicoService.listaPaginada(filtro.getPage(), filtro.getCount(), orderBy, filtro);
            response = Response.ok().entity(resultados).build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }
}
