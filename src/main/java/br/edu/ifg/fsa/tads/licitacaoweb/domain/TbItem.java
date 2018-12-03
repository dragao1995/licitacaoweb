package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TbItem.
 */
@Entity
@Table(name = "tb_item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tbitem")
public class TbItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "uasg", nullable = false)
    private Long uasg;

    @Column(name = "codigo_item_material")
    private Long codigoItemMaterial;

    @Column(name = "codigo_item_servico")
    private Long codigoItemServico;

    @Column(name = "descricao_item")
    private String descricaoItem;

    @NotNull
    @Column(name = "numero_licitacao", nullable = false)
    private String numeroLicitacao;

    @Column(name = "quantidade")
    private Long quantidade;

    @Column(name = "unidade")
    private String unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private TbLicitacao licitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    private TbServico servico;

    @ManyToOne(fetch = FetchType.LAZY)
    private TbMaterial material;

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

    public TbItem uasg(Long uasg) {
        this.uasg = uasg;
        return this;
    }

    public void setUasg(Long uasg) {
        this.uasg = uasg;
    }

    public Long getCodigoItemMaterial() {
        return codigoItemMaterial;
    }

    public TbItem codigoItemMaterial(Long codigoItemMaterial) {
        this.codigoItemMaterial = codigoItemMaterial;
        return this;
    }

    public void setCodigoItemMaterial(Long codigoItemMaterial) {
        this.codigoItemMaterial = codigoItemMaterial;
    }

    public Long getCodigoItemServico() {
        return codigoItemServico;
    }

    public TbItem codigoItemServico(Long codigoItemServico) {
        this.codigoItemServico = codigoItemServico;
        return this;
    }

    public void setCodigoItemServico(Long codigoItemServico) {
        this.codigoItemServico = codigoItemServico;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public TbItem descricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
        return this;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public String getNumeroLicitacao() {
        return numeroLicitacao;
    }

    public TbItem numeroLicitacao(String numeroLicitacao) {
        this.numeroLicitacao = numeroLicitacao;
        return this;
    }

    public void setNumeroLicitacao(String numeroLicitacao) {
        this.numeroLicitacao = numeroLicitacao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public TbItem quantidade(Long quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public TbItem unidade(String unidade) {
        this.unidade = unidade;
        return this;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public TbLicitacao getLicitacao() {
        return licitacao;
    }

    public TbItem licitacao(TbLicitacao tbLicitacao) {
        this.licitacao = tbLicitacao;
        return this;
    }

    public void setLicitacao(TbLicitacao tbLicitacao) {
        this.licitacao = tbLicitacao;
    }

    public TbServico getServico() {
        return servico;
    }

    public TbItem servico(TbServico tbServico) {
        this.servico = tbServico;
        return this;
    }

    public void setServico(TbServico tbServico) {
        this.servico = tbServico;
    }

    public TbMaterial getMaterial() {
        return material;
    }

    public TbItem material(TbMaterial tbMaterial) {
        this.material = tbMaterial;
        return this;
    }

    public void setMaterial(TbMaterial tbMaterial) {
        this.material = tbMaterial;
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
        TbItem tbItem = (TbItem) o;
        if (tbItem.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbItem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbItem{" +
            "id=" + getId() +
            ", uasg=" + getUasg() +
            ", codigoItemMaterial=" + getCodigoItemMaterial() +
            ", codigoItemServico=" + getCodigoItemServico() +
            ", descricaoItem='" + getDescricaoItem() + "'" +
            ", numeroLicitacao=" + getNumeroLicitacao() +
            ", quantidade=" + getQuantidade() +
            ", unidade='" + getUnidade() + "'" +
            "}";
    }
}
