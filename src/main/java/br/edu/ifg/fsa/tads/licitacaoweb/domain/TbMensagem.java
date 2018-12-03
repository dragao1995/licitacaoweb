package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A TbMensagem.
 */
@Entity
@Table(name = "tb_mensagem")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tbmensagem")
public class TbMensagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal;

    @Lob
    @Column(name = "descricao")
    private byte[] descricao;

    @Column(name = "descricao_content_type")
    private String descricaoContentType;

    @Column(name = "quantidade")
    private Double quantidade;

    @Column(name = "uasg_destino")
    private Long uasgDestino;

    @Column(name = "uasg_envio")
    private Long uasgEnvio;

    @ManyToOne
    @JoinColumn
    private TbLicitacao licitacao;

    @ManyToOne
    @JoinColumn
    private TbMaterial material;

    @ManyToOne
    @JoinColumn
    private TbServico servico;

    @OneToOne
    @JoinColumn(unique = true)
    private TbMensagem mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    private TbCabecalho cabecalho;

    @Column(name = "protocolo")
    private Long protocolo;

    @Column(name = "status")
    private String status;

    @Column(name = "resposta")
    private String resposta;


    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "tb_mensagem_documento",
               joinColumns = @JoinColumn(name="tb_mensagems_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="documentos_id", referencedColumnName="id"))
    private Set<TbDocumento> documentos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public TbMensagem dataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public TbMensagem dataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
        return this;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public byte[] getDescricao() {
        return descricao;
    }

    public TbMensagem descricao(byte[] descricao) {
        this.descricao = descricao;
        return this;
    }

    public void setDescricao(byte[] descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoContentType() {
        return descricaoContentType;
    }

    public TbMensagem descricaoContentType(String descricaoContentType) {
        this.descricaoContentType = descricaoContentType;
        return this;
    }

    public void setDescricaoContentType(String descricaoContentType) {
        this.descricaoContentType = descricaoContentType;
    }

    public TbLicitacao getLicitacao() {
        return licitacao;
    }

    public TbMensagem licitacao(TbLicitacao tbLicitacao) {
        this.licitacao = tbLicitacao;
        return this;
    }

    public void setLicitacao(TbLicitacao tbLicitacao) {
        this.licitacao = tbLicitacao;
    }

    public TbMensagem getMensagem() {
        return mensagem;
    }

    public TbMensagem mensagem(TbMensagem tbMensagem) {
        this.mensagem = tbMensagem;
        return this;
    }

    public void setMensagem(TbMensagem tbMensagem) {
        this.mensagem = tbMensagem;
    }

    public TbCabecalho getCabecalho() {
        return cabecalho;
    }

    public TbMensagem cabecalho(TbCabecalho tbCabecalho) {
        this.cabecalho = tbCabecalho;
        return this;
    }

    public void setCabecalho(TbCabecalho tbCabecalho) {
        this.cabecalho = tbCabecalho;
    }

    public Set<TbDocumento> getDocumentos() {
        return documentos;
    }

    public TbMensagem documentos(Set<TbDocumento> tbDocumentos) {
        this.documentos = tbDocumentos;
        return this;
    }

    public TbMensagem addDocumento(TbDocumento tbDocumento) {
        this.documentos.add(tbDocumento);
        return this;
    }

    public TbMensagem removeDocumento(TbDocumento tbDocumento) {
        this.documentos.remove(tbDocumento);
        return this;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Long getUasgDestino() {
        return uasgDestino;
    }

    public void setUasgDestino(Long uasgDestino) {
        this.uasgDestino = uasgDestino;
    }

    public Long getUasgEnvio() {
        return uasgEnvio;
    }

    public void setUasgEnvio(Long uasgEnvio) {
        this.uasgEnvio = uasgEnvio;
    }

    public TbMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TbMaterial material) {
        this.material = material;
    }

    public TbServico getServico() {
        return servico;
    }

    public void setServico(TbServico servico) {
        this.servico = servico;
    }

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setDocumentos(Set<TbDocumento> tbDocumentos) {
        this.documentos = tbDocumentos;
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
        TbMensagem tbMensagem = (TbMensagem) o;
        if (tbMensagem.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbMensagem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbMensagem{" +
            "id=" + getId() +
            ", dataInicio='" + getDataInicio() + "'" +
            ", dataFinal='" + getDataFinal() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", descricaoContentType='" + getDescricaoContentType() + "'" +
            "}";
    }
}
