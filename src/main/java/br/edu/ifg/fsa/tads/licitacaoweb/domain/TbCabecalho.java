package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TbCabecalho.
 */
@Entity
@Table(name = "tb_cabecalho")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tbcabecalho")
public class TbCabecalho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    @Column(name = "cabecalho", nullable = false)
    private byte[] cabecalho;

    @Column(name = "cabecalho_content_type", nullable = false)
    private String cabecalhoContentType;

    @Column(name = "iniciado")
    private Boolean iniciado;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getCabecalho() {
        return cabecalho;
    }

    public TbCabecalho cabecalho(byte[] cabecalho) {
        this.cabecalho = cabecalho;
        return this;
    }

    public void setCabecalho(byte[] cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getCabecalhoContentType() {
        return cabecalhoContentType;
    }

    public TbCabecalho cabecalhoContentType(String cabecalhoContentType) {
        this.cabecalhoContentType = cabecalhoContentType;
        return this;
    }

    public void setCabecalhoContentType(String cabecalhoContentType) {
        this.cabecalhoContentType = cabecalhoContentType;
    }

    public Boolean isIniciado() {
        return iniciado;
    }

    public TbCabecalho iniciado(Boolean iniciado) {
        this.iniciado = iniciado;
        return this;
    }

    public void setIniciado(Boolean iniciado) {
        this.iniciado = iniciado;
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
        TbCabecalho tbCabecalho = (TbCabecalho) o;
        if (tbCabecalho.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbCabecalho.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbCabecalho{" +
            "id=" + getId() +
            ", cabecalho='" + getCabecalho() + "'" +
            ", cabecalhoContentType='" + getCabecalhoContentType() + "'" +
            ", iniciado='" + isIniciado() + "'" +
            "}";
    }
}
