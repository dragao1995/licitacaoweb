package br.edu.ifg.fsa.tads.licitacaoweb.service.XML;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "resource")
public class ServicoXML {
    @XmlElement(name = "_embedded")
    ServicoXML.Embedded embeddeds;

    public Embedded getEmbeddeds() {
        return embeddeds;
    }

    public void setEmbeddeds(Embedded embeddeds) {
        this.embeddeds = embeddeds;
    }

    public static class Embedded {

        @XmlElement(name = "resource")
        private List<Resource> resource;

        public List<Resource> getResources() {
            return resource;
        }

        public void setResources(List<Resource> resources) {
            this.resource = resources;
        }
    }

    public static class Resource {
        @XmlElement(name = "codigo", required = true)
        private Long codigo1;

        @XmlElement(name = "descricao", required = true)
        private String descricao1;

        @XmlElement(name = "unidade_medida", required = false)
        private String unidade_medida1;

        @XmlElement(name = "cpc", required = false)
        private String cpc1;

        public Long getCodigo() {
            return codigo1;
        }

        public void setCodigo(Long codigo) {
            this.codigo1 = codigo;
        }

        public String getDescricao() {
            return descricao1;
        }

        public void setDescricao(String descricao) {
            this.descricao1 = descricao;
        }

        public String getUnidade_medida() {
            return unidade_medida1;
        }

        public void setUnidade_medida(String unidade_medida) {
            this.unidade_medida1 = unidade_medida;
        }

        public String getCpc() {
            return cpc1;
        }

        public void setCpc(String cpc) {
            this.cpc1 = cpc;
        }
    }
}
