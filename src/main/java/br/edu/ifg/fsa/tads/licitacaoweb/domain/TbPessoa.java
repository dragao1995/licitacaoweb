package br.edu.ifg.fsa.tads.licitacaoweb.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A TbPessoa.
 */
@Entity
@Table(name = "tb_pessoa")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "tbpessoa")
public class TbPessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "login", nullable = false)
    private String login;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

    @NotNull
    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    private TbInstituicao instituicao;

    @ManyToOne(fetch = FetchType.LAZY)
    private TbContato contato;

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

    public TbPessoa nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public TbPessoa login(String login) {
        this.login = login;
        return this;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public TbPessoa senha(String senha) {
        this.senha = senha;
        return this;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public TbPessoa telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public TbPessoa tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TbInstituicao getInstituicao() {
        return instituicao;
    }

    public TbPessoa instituicao(TbInstituicao tbInstituicao) {
        this.instituicao = tbInstituicao;
        return this;
    }

    public void setInstituicao(TbInstituicao tbInstituicao) {
        this.instituicao = tbInstituicao;
    }

    public TbContato getContato() {
        return contato;
    }

    public TbPessoa contato(TbContato tbContato) {
        this.contato = tbContato;
        return this;
    }

    public void setContato(TbContato tbContato) {
        this.contato = tbContato;
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
        TbPessoa tbPessoa = (TbPessoa) o;
        if (tbPessoa.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tbPessoa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TbPessoa{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", login='" + getLogin() + "'" +
            ", senha='" + getSenha() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
}
