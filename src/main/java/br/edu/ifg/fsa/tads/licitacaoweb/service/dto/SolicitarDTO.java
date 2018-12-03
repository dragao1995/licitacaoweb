package br.edu.ifg.fsa.tads.licitacaoweb.service.dto;

import java.io.Serializable;

public class SolicitarDTO implements Serializable {
    Double quantidade;
    Long uasgEnvio;
    Long uasgDestino;
    Long idLicitacao;
    Long idServico;
    Long idMaterial;

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
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

    public Long getIdLicitacao() {
        return idLicitacao;
    }

    public void setIdLicitacao(Long idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }
}
