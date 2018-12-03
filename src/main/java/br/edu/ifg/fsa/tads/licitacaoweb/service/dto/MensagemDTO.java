package br.edu.ifg.fsa.tads.licitacaoweb.service.dto;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbLicitacao;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbServico;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.BaseVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MensagemDTO implements BaseVO<MensagemDTO, TbMensagem> {

    private Long id;
    private LicitacaoDTO licitacao;
    private MaterialDTO material;
    private ServicoDTO servico;
    private Long uasgEnvio;
    private Long uasgDestino;
    private LocalDate dataInicio;
    private Long protocolo;
    private String status;
    private Double quantidade;
    private String resposta;

    @Override
    public List<MensagemDTO> toList(List<TbMensagem> entidades) {
        List<MensagemDTO> vos = new ArrayList<>();
        for (TbMensagem i : entidades) {
            vos.add(toVO(i));
        }
        return vos;
    }

    @Override
    public MensagemDTO toVO(TbMensagem m) {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setId(m.getId());
        mensagemDTO.setLicitacao(new LicitacaoDTO().toVO(m.getLicitacao()));

        if(m.getMaterial() != null)
        mensagemDTO.setMaterial(new MaterialDTO().toVO(m.getMaterial()));

        if(m.getServico() != null)
        mensagemDTO.setServico(new ServicoDTO().toVO(m.getServico()));

        mensagemDTO.setUasgEnvio(m.getUasgEnvio());
        mensagemDTO.setUasgDestino(m.getUasgDestino());
        mensagemDTO.setDataInicio(m.getDataInicio());
        mensagemDTO.setProtocolo(m.getProtocolo());
        mensagemDTO.setStatus(m.getStatus());
        mensagemDTO.setQuantidade(m.getQuantidade());
        mensagemDTO.setResposta(m.getResposta());

        return mensagemDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LicitacaoDTO getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(LicitacaoDTO licitacao) {
        this.licitacao = licitacao;
    }

    public MaterialDTO getMaterial() {
        return material;
    }

    public void setMaterial(MaterialDTO material) {
        this.material = material;
    }

    public ServicoDTO getServico() {
        return servico;
    }

    public void setServico(ServicoDTO servico) {
        this.servico = servico;
    }

    public Long getUasgEnvio() {
        return uasgEnvio;
    }

    public void setUasgEnvio(Long uasgEnvio) {
        this.uasgEnvio = uasgEnvio;
    }

    public Long getUasgDestino() {
        return uasgDestino;
    }

    public void setUasgDestino(Long uasgDestino) {
        this.uasgDestino = uasgDestino;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
