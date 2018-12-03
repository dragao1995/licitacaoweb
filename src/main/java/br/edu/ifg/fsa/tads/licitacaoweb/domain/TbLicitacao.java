package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A TbLicitacao.
 */
@Entity
@Table(name = "tb_licitacao")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tblicitacao")
public class TbLicitacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "uasg")
    private Long uasg;

    @Column(name = "modalidade")
    private Integer modalidade;

    @Column(name = "funcao_responsavel")
    private String funcaoResponsavel;

    @Column(name = "identificador", nullable = false)
    private String identificador;

    @Column(name = "situacao_aviso")
    private String situacaoAviso;

    @Column(name = "objeto")
    private String objeto;

    @Column(name = "informcoes_gerais")
    private String informcoesGerais;

    @Column(name = "numero_processo")
    private Long numeroProcesso;

    @Column(name = "tipo_recurso")
    private String tipoRecurso;


    @Column(name = "numero_itens")
    private Long numeroItens;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "data_entregaedital")
    private LocalDate dataEntregaedital;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @Column(name = "endereco_entrega_edital")
    private String enderecoEntregaEdital;

    @Column(name = "data_entrega_proposta")
    private LocalDate dataEntregaProposta;

    @Column(name = "uasg_descricao")
    private String uasgDescricao;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUasg() {
        return uasg;
    }

    public TbLicitacao uasg(Long uasg) {
        this.uasg = uasg;
        return this;
    }

    public void setUasg(Long uasg) {
        this.uasg = uasg;
    }

    public Integer getModalidade() {
        return modalidade;
    }

    public TbLicitacao modalidade(Integer modalidade) {
        this.modalidade = modalidade;
        return this;
    }

    public void setModalidade(Integer modalidade) {
        this.modalidade = modalidade;
    }

    public String getFuncaoResponsavel() {
        return funcaoResponsavel;
    }

    public TbLicitacao funcaoResponsavel(String funcaoResponsavel) {
        this.funcaoResponsavel = funcaoResponsavel;
        return this;
    }

    public void setFuncaoResponsavel(String funcaoResponsavel) {
        this.funcaoResponsavel = funcaoResponsavel;
    }

    public String getIdentificador() {
        return identificador;
    }

    public TbLicitacao identificador(String identificador) {
        this.identificador = identificador;
        return this;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSituacaoAviso() {
        return situacaoAviso;
    }

    public TbLicitacao situacaoAviso(String situacaoAviso) {
        this.situacaoAviso = situacaoAviso;
        return this;
    }

    public void setSituacaoAviso(String situacaoAviso) {
        this.situacaoAviso = situacaoAviso;
    }

    public String getObjeto() {
        return objeto;
    }

    public TbLicitacao objeto(String objeto) {
        this.objeto = objeto;
        return this;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getInformcoesGerais() {
        return informcoesGerais;
    }

    public TbLicitacao informcoesGerais(String informcoesGerais) {
        this.informcoesGerais = informcoesGerais;
        return this;
    }

    public void setInformcoesGerais(String informcoesGerais) {
        this.informcoesGerais = informcoesGerais;
    }

    public Long getNumeroProcesso() {
        return numeroProcesso;
    }

    public TbLicitacao numeroProcesso(Long numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
        return this;
    }

    public void setNumeroProcesso(Long numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public TbLicitacao tipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
        return this;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public Long getNumeroItens() {
        return numeroItens;
    }

    public TbLicitacao numeroItens(Long numeroItens) {
        this.numeroItens = numeroItens;
        return this;
    }

    public void setNumeroItens(Long numeroItens) {
        this.numeroItens = numeroItens;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public TbLicitacao dataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
        return this;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LocalDate getDataEntregaedital() {
        return dataEntregaedital;
    }

    public TbLicitacao dataEntregaedital(LocalDate dataEntregaedital) {
        this.dataEntregaedital = dataEntregaedital;
        return this;
    }

    public void setDataEntregaedital(LocalDate dataEntregaedital) {
        this.dataEntregaedital = dataEntregaedital;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public TbLicitacao nomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
        return this;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getEnderecoEntregaEdital() {
        return enderecoEntregaEdital;
    }

    public TbLicitacao enderecoEntregaEdital(String enderecoEntregaEdital) {
        this.enderecoEntregaEdital = enderecoEntregaEdital;
        return this;
    }

    public void setEnderecoEntregaEdital(String enderecoEntregaEdital) {
        this.enderecoEntregaEdital = enderecoEntregaEdital;
    }

    public LocalDate getDataEntregaProposta() {
        return dataEntregaProposta;
    }

    public TbLicitacao dataEntregaProposta(LocalDate dataEntregaProposta) {
        this.dataEntregaProposta = dataEntregaProposta;
        return this;
    }

    public void setDataEntregaProposta(LocalDate dataEntregaProposta) {
        this.dataEntregaProposta = dataEntregaProposta;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TbLicitacao tbLicitacao = (TbLicitacao) o;
        if (tbLicitacao.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbLicitacao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbLicitacao{" +
            "id=" + getId() +
            ", uasg=" + getUasg() +
            ", modalidade=" + getModalidade() +
            ", funcaoResponsavel='" + getFuncaoResponsavel() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            ", situacaoAviso='" + getSituacaoAviso() + "'" +
            ", objeto='" + getObjeto() + "'" +
            ", informcoesGerais='" + getInformcoesGerais() + "'" +
            ", numeroProcesso=" + getNumeroProcesso() +
            ", tipoRecurso='" + getTipoRecurso() + "'" +
            ", numeroItens=" + getNumeroItens() +
            ", dataPublicacao='" + getDataPublicacao() + "'" +
            ", dataEntregaedital='" + getDataEntregaedital() + "'" +
            ", nomeResponsavel='" + getNomeResponsavel() + "'" +
            ", enderecoEntregaEdital='" + getEnderecoEntregaEdital() + "'" +
            ", dataEntregaProposta='" + getDataEntregaProposta() + "'" +
            "}";
    }

    public String getUasgDescricao() {
        return uasgDescricao;
    }

    public void setUasgDescricao(String uasgDescricao) {
        this.uasgDescricao = uasgDescricao;
    }
}
