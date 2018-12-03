package br.edu.ifg.fsa.tads.licitacaoweb.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FiltroRequisicaoDTO implements Serializable {
    private Long id;
    private String identificador;
    private Long uasg;
    private String uasgDescricao;
    private Long dataInicial;
    private Long dataFinal;
    String tipo;
    Long codigo;
    String descricao;
    String status;
    Long uasgUsuario;
    Long protocolo;
    String observacao;

    private Integer page;
    private Integer count;
    private String campo;
    private String ordem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Long getUasg() {
        return uasg;
    }

    public void setUasg(Long uasg) {
        this.uasg = uasg;
    }

    public String getUasgDescricao() {
        return uasgDescricao;
    }

    public void setUasgDescricao(String uasgDescricao) {
        this.uasgDescricao = uasgDescricao;
    }

    public Long getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Long dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Long getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Long dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public Long getUasgUsuario() {
        return uasgUsuario;
    }

    public void setUasgUsuario(Long uasgUsuario) {
        this.uasgUsuario = uasgUsuario;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
