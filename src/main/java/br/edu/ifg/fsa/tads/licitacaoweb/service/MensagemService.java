package br.edu.ifg.fsa.tads.licitacaoweb.service;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbMensagemRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.FiltroRequisicaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MensagemDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.LazyResultVO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("prototype")
public class MensagemService {

    @Autowired
    TbMensagemRepository tbMensagemRepository;

    @Transactional
    public LazyResultVO<MensagemDTO> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, FiltroRequisicaoDTO filtro, boolean resposta) {
        LazyResultVO<MensagemDTO> resultado = new LazyResultVO<>();

        List<TbMensagem> lista = tbMensagemRepository.listaPaginada(pagina, limite, orderBy, filtro,resposta);
        resultado.setResultados(new MensagemDTO().toList(lista));
        resultado.setTotal(tbMensagemRepository.recuperarTotal(filtro, resposta));

        return resultado;
    }

    public void responder(Long id, String observacao, boolean aceito) {
        TbMensagem mensagem = tbMensagemRepository.recuperarEntidadeMapeadaPorId(id, TbMensagem.class);
        mensagem.setResposta(observacao);

        if(aceito){
            mensagem.setStatus("Aceito");
        }else {
            mensagem.setStatus("Rejeitado");
        }

        tbMensagemRepository.atualizar(mensagem);
    }
}
