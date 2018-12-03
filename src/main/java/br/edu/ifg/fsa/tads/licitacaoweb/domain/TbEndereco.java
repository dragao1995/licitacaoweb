package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TbEndereco.
 */
@Entity
@Table(name = "tb_endereco")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tbendereco")
public class TbEndereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "u_f", nullable = false)
    private String uF;

    @NotNull
    @Column(name = "cidade", nullable = false)
    private String cidade;

    @NotNull
    @Column(name = "municipio", nullable = false)
    private String municipio;

    @NotNull
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "observacao")
    private String observacao;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getuF() {
        return uF;
    }

    public TbEndereco uF(String uF) {
        this.uF = uF;
        return this;
    }

    public void setuF(String uF) {
        this.uF = uF;
    }

    public String getCidade() {
        return cidade;
    }

    public TbEndereco cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMunicipio() {
        return municipio;
    }

    public TbEndereco municipio(String municipio) {
        this.municipio = municipio;
        return this;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEndereco() {
        return endereco;
    }

    public TbEndereco endereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public TbEndereco observacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        TbEndereco tbEndereco = (TbEndereco) o;
        if (tbEndereco.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbEndereco.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbEndereco{" +
            "id=" + getId() +
            ", uF='" + getuF() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", municipio='" + getMunicipio() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", observacao='" + getObservacao() + "'" +
            "}";
    }
}
