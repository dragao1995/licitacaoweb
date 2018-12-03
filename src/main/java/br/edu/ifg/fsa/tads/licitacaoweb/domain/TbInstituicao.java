package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A TbInstituicao.
 */
@Entity
@Table(name = "tb_instituicao")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tbinstituicao")
public class TbInstituicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "obeservacao")
    private String obeservacao;

    @OneToOne
    @JoinColumn(unique = true)
    private TbEndereco endereco;

    @OneToOne
    @JoinColumn(unique = true)
    private TbContato contato;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "tb_instituicao_cabecalho",
               joinColumns = @JoinColumn(name="tb_instituicaos_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="cabecalhos_id", referencedColumnName="id"))
    private Set<TbCabecalho> cabecalhos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public TbInstituicao nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObeservacao() {
        return obeservacao;
    }

    public TbInstituicao obeservacao(String obeservacao) {
        this.obeservacao = obeservacao;
        return this;
    }

    public void setObeservacao(String obeservacao) {
        this.obeservacao = obeservacao;
    }

    public TbEndereco getEndereco() {
        return endereco;
    }

    public TbInstituicao endereco(TbEndereco tbEndereco) {
        this.endereco = tbEndereco;
        return this;
    }

    public void setEndereco(TbEndereco tbEndereco) {
        this.endereco = tbEndereco;
    }

    public TbContato getContato() {
        return contato;
    }

    public TbInstituicao contato(TbContato tbContato) {
        this.contato = tbContato;
        return this;
    }

    public void setContato(TbContato tbContato) {
        this.contato = tbContato;
    }

    public Set<TbCabecalho> getCabecalhos() {
        return cabecalhos;
    }

    public TbInstituicao cabecalhos(Set<TbCabecalho> tbCabecalhos) {
        this.cabecalhos = tbCabecalhos;
        return this;
    }

    public TbInstituicao addCabecalho(TbCabecalho tbCabecalho) {
        this.cabecalhos.add(tbCabecalho);
        return this;
    }

    public TbInstituicao removeCabecalho(TbCabecalho tbCabecalho) {
        this.cabecalhos.remove(tbCabecalho);
        return this;
    }

    public void setCabecalhos(Set<TbCabecalho> tbCabecalhos) {
        this.cabecalhos = tbCabecalhos;
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
        TbInstituicao tbInstituicao = (TbInstituicao) o;
        if (tbInstituicao.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbInstituicao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbInstituicao{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", obeservacao='" + getObeservacao() + "'" +
            "}";
    }
}
