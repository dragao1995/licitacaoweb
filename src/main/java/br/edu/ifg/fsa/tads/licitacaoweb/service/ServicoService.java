package br.edu.ifg.fsa.tads.licitacaoweb.service;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbServico;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbMaterialRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbServicoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MaterialDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.ServicoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("prototype")
public class ServicoService {

    @Autowired
    TbServicoRepository tbServicoRepository;

    @Transactional
    public LazyResultVO<ServicoDTO> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, ServicoDTO filtro) {
        LazyResultVO<ServicoDTO> resultado = new LazyResultVO<>();

            List<TbServico> lista = tbServicoRepository.listaPaginada(pagina, limite, orderBy, filtro);
            resultado.setResultados(new ServicoDTO().toList(lista));
            resultado.setTotal(tbServicoRepository.recuperarTotal(filtro));

        return resultado;
    }
}
