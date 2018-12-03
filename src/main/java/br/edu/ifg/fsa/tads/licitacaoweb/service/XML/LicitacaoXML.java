package br.edu.ifg.fsa.tads.licitacaoweb.service.XML;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "resource")
public class LicitacaoXML {
    @XmlElement(name = "_embedded")
    LicitacaoXML.Embedded embeddeds;

    public Embedded getEmbeddeds() {
        return embeddeds;
    }

    public void setEmbeddeds(Embedded embeddeds) {
        this.embeddeds = embeddeds;
    }

    public static class Embedded {

        @XmlElement(name = "resource")
        private List<Resource> resources;

        public List<Resource> getResources1() {
            return resources;
        }

        public void setResources1(List<Resource> resources1) {
            this.resources = resources1;
        }
    }

    public static class Resource {
        @XmlElement(name = "uasg")
        private Long uasg;

        @XmlElement(name = "modalidade")
        private Long modalidade;

        @XmlElement(name = "numero_aviso")
        private Long numero_aviso;

        @XmlElement(name = "identificador")
        private String identificador;

        @XmlElement(name = "situacao_aviso")
        private String situacao_aviso;

        @XmlElement(name = "objeto")
        private String objeto;

        @XmlElement(name = "informacoes_gerais")
        private String informacoes_gerais;

        @XmlElement(name = "numero_processo")
        private Long numero_processo;

        @XmlElement(name = "tipo_recurso")
        private String tipo_recurso;

        @XmlElement(name = "numero_itens")
        private Double numero_itens;

        @XmlElement(name = "nome_responsavel")
        private String nome_responsavel;

        @XmlElement(name = "funcao_responsavel")
        private String funcao_responsavel;

        @XmlElement(name = "data_entrega_edital")
        private Date data_entrega_edital;

        @XmlElement(name = "endereco_entrega_edital")
        private String endereco_entrega_edital;

        @XmlElement(name = "data_entrega_proposta")
        private Date data_entrega_proposta;

        @XmlElement(name = "data_publicacao")
        private Date data_publicacao;

        public Long getUasg1() {
            return uasg;
        }

        public void setUasg1(Long uasg1) {
            this.uasg = uasg1;
        }

        public Long getModalidade1() {
            return modalidade;
        }

        public void setModalidade1(Long modalidade1) {
            this.modalidade = modalidade1;
        }

        public Long getNumero_aviso1() {
            return numero_aviso;
        }

        public void setNumero_aviso1(Long numero_aviso1) {
            this.numero_aviso = numero_aviso1;
        }

        public String getIdentificador1() {
            return identificador;
        }

        public void setIdentificador1(String identificador1) {
            this.identificador = identificador1;
        }

        public String getSituacao_aviso1() {
            return situacao_aviso;
        }

        public void setSituacao_aviso1(String situacao_aviso1) {
            this.situacao_aviso = situacao_aviso1;
        }

        public String getObjeto1() {
            return objeto;
        }

        public void setObjeto1(String objeto1) {
            this.objeto = objeto1;
        }

        public String getInformacoes_gerais1() {
            return informacoes_gerais;
        }

        public void setInformacoes_gerais1(String informacoes_gerais1) {
            this.informacoes_gerais = informacoes_gerais1;
        }

        public Long getNumero_processo1() {
            return numero_processo;
        }

        public void setNumero_processo1(Long numero_processo1) {
            this.numero_processo = numero_processo1;
        }

        public String getTipo_recurso1() {
            return tipo_recurso;
        }

        public void setTipo_recurso1(String tipo_recurso1) {
            this.tipo_recurso = tipo_recurso1;
        }

        public Double getNumero_itens1() {
            return numero_itens;
        }

        public void setNumero_itens1(Double numero_itens1) {
            this.numero_itens = numero_itens1;
        }

        public String getNome_responsavel1() {
            return nome_responsavel;
        }

        public void setNome_responsavel1(String nome_responsavel1) {
            this.nome_responsavel = nome_responsavel1;
        }

        public String getFuncao_responsavel1() {
            return funcao_responsavel;
        }

        public void setFuncao_responsavel1(String funcao_responsavel1) {
            this.funcao_responsavel = funcao_responsavel1;
        }

        public Date getData_entrega_edital1() {
            return data_entrega_edital;
        }

        public void setData_entrega_edital1(Date data_entrega_edital1) {
            this.data_entrega_edital = data_entrega_edital1;
        }

        public String getEndereco_entrega_edital1() {
            return endereco_entrega_edital;
        }

        public void setEndereco_entrega_edital1(String endereco_entrega_edital1) {
            this.endereco_entrega_edital = endereco_entrega_edital1;
        }

        public Date getData_entrega_proposta1() {
            return data_entrega_proposta;
        }

        public void setData_entrega_proposta1(Date data_entrega_proposta1) {
            this.data_entrega_proposta = data_entrega_proposta1;
        }

        public Date getData_publicacao1() {
            return data_publicacao;
        }

        public void setData_publicacao1(Date data_publicacao1) {
            this.data_publicacao = data_publicacao1;
        }
    }

}
