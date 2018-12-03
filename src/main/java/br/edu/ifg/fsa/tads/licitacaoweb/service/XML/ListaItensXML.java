package br.edu.ifg.fsa.tads.licitacaoweb.service.XML;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "resource")
public class ListaItensXML {

    @XmlElement(name = "_embedded")
    ListaItensXML.Embedded embeddeds;

    public Embedded getEmbeddeds() {
        return embeddeds;
    }

    public void setEmbeddeds(Embedded embeddeds) {
        this.embeddeds = embeddeds;
    }

    public static class Embedded {

        @XmlElement(name = "resource")
        private List<Resource> resources1;

        public List<Resource> getResources() {
            return resources1;
        }

        public void setResources(List<Resource> resources) {
            this.resources1 = resources;
        }
    }

    public static class Resource {
        @XmlElement(name = "uasg", required = true)
        private Long uasg1;

        @XmlElement(name = "numero_licitacao", required = true)
        private String numero_licitacao1;

        @XmlElement(name = "codigo_item_material", required = true)
        private Long codigo_item_material1;

        @XmlElement(name = "codigo_item_servico", required = true)
        private Long codigo_item_servico1;

        @XmlElement(name = "descricao_item", required = true)
        private String descricao_item1;

        @XmlElement(name = "quantidade", required = true)
        private Double quantidade1;

        @XmlElement(name = "unidade", required = true)
        private String unidade1;

        public Long getUasg() {
            return uasg1;
        }

        public void setUasg(Long uasg) {
            this.uasg1 = uasg;
        }

        public String getNumero_licitacao() {
            return numero_licitacao1;
        }

        public void setNumero_licitacao(String numero_licitacao) {
            this.numero_licitacao1 = numero_licitacao;
        }

        public Long getCodigo_item_material() {
            return codigo_item_material1;
        }

        public void setCodigo_item_material(Long codigo_item_material) {
            this.codigo_item_material1 = codigo_item_material;
        }

        public Long getCodigo_item_servico() {
            return codigo_item_servico1;
        }

        public void setCodigo_item_servico(Long codigo_item_servico) {
            this.codigo_item_servico1 = codigo_item_servico;
        }

        public String getDescricao_item() {
            return descricao_item1;
        }

        public void setDescricao_item(String descricao_item) {
            this.descricao_item1 = descricao_item;
        }

        public Double getQuantidade() {
            return quantidade1;
        }

        public void setQuantidade(Double quantidade) {
            this.quantidade1 = quantidade;
        }

        public String getUnidade() {
            return unidade1;
        }

        public void setUnidade(String unidade) {
            this.unidade1 = unidade;
        }
    }
}
