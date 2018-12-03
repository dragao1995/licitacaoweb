package br.edu.ifg.fsa.tads.licitacaoweb.service.dto;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbLicitacao;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LicitacaoDTO implements BaseVO<LicitacaoDTO, TbLicitacao> {

    private List<String> selectedCampus;
    private String campusGerenciador;
    private String descricaoObjeto;
    private Integer nItem;
    private Integer nPregao;
    private Date prazo;
    private Integer qtdDemanda;
    private Integer qtdRemanescente;
    private Integer qtdTotalAta;

    private Long id;
    private String identificador;
    private Long numeroProcesso;
    private Long uasg;
    private String uasgDescricao;
    private Long codigoServico;
    private Long codigoMaterial;
    private LocalDate dataPublicacao;
    private LocalDate dataEntregaedital;
    private LocalDate dataEntregaProposta;


    Integer page;
    Integer count;
    String campo;
    String ordem;

    @Override
    public List<LicitacaoDTO> toList(List<TbLicitacao> entidades) {
        List<LicitacaoDTO> vos = new ArrayList<>();
        for (TbLicitacao i : entidades) {
            vos.add(toVO(i));
        }
        return vos;
    }

    @Override
    public LicitacaoDTO toVO(TbLicitacao tb) {
        LicitacaoDTO dTO = new LicitacaoDTO();
        dTO.setId(tb.getId());
        dTO.setUasg(tb.getUasg());
        dTO.setUasgDescricao(tb.getUasgDescricao());
        dTO.setIdentificador(tb.getIdentificador());
        dTO.setNumeroProcesso(tb.getNumeroProcesso());
        dTO.setDataEntregaedital(tb.getDataEntregaedital());
        dTO.setDataEntregaProposta(tb.getDataEntregaProposta());
        dTO.setDataPublicacao(tb.getDataPublicacao());

        return dTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getSelectedCampus() {
        return selectedCampus;
    }

    public void setSelectedCampus(List<String> selectedCampus) {
        this.selectedCampus = selectedCampus;
    }

    public String getCampusGerenciador() {
        return campusGerenciador;
    }

    public void setCampusGerenciador(String campusGerenciador) {
        this.campusGerenciador = campusGerenciador;
    }

    public String getDescricaoObjeto() {
        return descricaoObjeto;
    }

    public void setDescricaoObjeto(String descricaoObjeto) {
        this.descricaoObjeto = descricaoObjeto;
    }

    public Integer getnItem() {
        return nItem;
    }

    public void setnItem(Integer nItem) {
        this.nItem = nItem;
    }

    public Integer getnPregao() {
        return nPregao;
    }

    public void setnPregao(Integer nPregao) {
        this.nPregao = nPregao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Integer getQtdDemanda() {
        return qtdDemanda;
    }

    public void setQtdDemanda(Integer qtdDemanda) {
        this.qtdDemanda = qtdDemanda;
    }

    public Integer getQtdRemanescente() {
        return qtdRemanescente;
    }

    public void setQtdRemanescente(Integer qtdRemanescente) {
        this.qtdRemanescente = qtdRemanescente;
    }

    public Integer getQtdTotalAta() {
        return qtdTotalAta;
    }

    public void setQtdTotalAta(Integer qtdTotalAta) {
        this.qtdTotalAta = qtdTotalAta;
    }

    public Long getUasg() {
        return uasg;
    }

    public void setUasg(Long uasg) {
        this.uasg = uasg;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Long getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(Long numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getUasgDescricao() {
        return uasgDescricao;
    }

    public void setUasgDescricao(String uasgDescricao) {
        this.uasgDescricao = uasgDescricao;
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

    public Long getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Long codigoServico) {
        this.codigoServico = codigoServico;
    }

    public Long getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(Long codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LocalDate getDataEntregaedital() {
        return dataEntregaedital;
    }

    public void setDataEntregaedital(LocalDate dataEntregaedital) {
        this.dataEntregaedital = dataEntregaedital;
    }

    public LocalDate getDataEntregaProposta() {
        return dataEntregaProposta;
    }

    public void setDataEntregaProposta(LocalDate dataEntregaProposta) {
        this.dataEntregaProposta = dataEntregaProposta;
    }
}
