package br.edu.ifg.fsa.tads.licitacaoweb.web.rest.material;

import br.edu.ifg.fsa.tads.licitacaoweb.service.MaterialService;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MaterialDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@Scope("prototype")
@RequestMapping("/api/material")
public class materialAPI {

    @Autowired
    MaterialService materialService;

    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public Response listar(@Valid MaterialDTO filtro
    ) {

        OrderBy orderBy = new OrderBy(filtro.getCampo(), filtro.getOrdem());
        Response response;
        LazyResultVO<MaterialDTO> resultados;
        try {
            resultados = materialService.listaPaginada(filtro.getPage(), filtro.getCount(), orderBy, filtro);
            response = Response.ok().entity(resultados).build();
        } catch (Exception e) {

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new Exception(e.getMessage().replaceAll(".*:", ""))).build();
        }
        return response;
    }
}
