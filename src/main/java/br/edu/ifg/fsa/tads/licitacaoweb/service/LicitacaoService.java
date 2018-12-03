package br.edu.ifg.fsa.tads.licitacaoweb.service;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.*;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.LicitacaoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbMaterialRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbMensagemRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbServicoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.LicitacaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.SolicitarDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Scope("prototype")
public class LicitacaoService {

    @Autowired
    private LicitacaoRepository licitacaoRepository;

    @Autowired
    TbMaterialRepository tbMaterialRepository;

    @Autowired
    TbServicoRepository tbServicoRepository;

    @Autowired
    TbMensagemRepository tbMensagemRepository;

    @Transactional
    public LazyResultVO<LicitacaoDTO> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, LicitacaoDTO filtro) {
        LazyResultVO<LicitacaoDTO> resultado = new LazyResultVO<>();

        List<TbItem> listaItem = licitacaoRepository.listaPaginada(pagina, limite, orderBy, filtro);
        List<TbLicitacao> listaLicitacao = new ArrayList<>();
        listaItem.forEach(item -> {
            TbLicitacao licicatao = item.getLicitacao();
            listaLicitacao.add(licicatao);
        });
        resultado.setResultados(new LicitacaoDTO().toList(listaLicitacao));
        resultado.setTotal(licitacaoRepository.recuperarTotal(filtro));

        return resultado;
    }

    @Transactional
    public String solicitar(SolicitarDTO filtro) {

        TbMensagem mensagem = new TbMensagem();
        mensagem.setQuantidade(filtro.getQuantidade());
        mensagem.setUasgDestino(filtro.getUasgDestino());
        mensagem.setUasgEnvio(filtro.getUasgEnvio());
        mensagem.setLicitacao(licitacaoRepository.recuperarEntidadeMapeadaPorId(filtro.getIdLicitacao(), TbLicitacao.class));

        if(filtro.getIdMaterial() != null)
            mensagem.setMaterial(tbMaterialRepository.recuperarEntidadeMapeadaPorId(filtro.getIdMaterial(),TbMaterial.class));

        if(filtro.getIdServico() != null)
            mensagem.setServico(tbServicoRepository.recuperarEntidadeMapeadaPorId(filtro.getIdServico(),TbServico.class));
        try {
            mensagem.setProtocolo(tbMensagemRepository.buscarMaxProtocolo()+1L);
        }catch (Exception e){
            mensagem.setProtocolo(1L);
        }
        mensagem.setDataInicio(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        mensagem.setStatus("Aguardando resposta");

        tbMensagemRepository.inserir(mensagem);

        return mensagem.getProtocolo().toString();
    }
}
