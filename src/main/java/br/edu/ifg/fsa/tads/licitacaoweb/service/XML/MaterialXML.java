package br.edu.ifg.fsa.tads.licitacaoweb.service.XML;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "resource")
public class MaterialXML {

    @XmlElement(name = "_embedded")
    MaterialXML.Embedded embeddeds;

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
        private String descricao;

        @XmlElement(name = "status", required = true)
        private boolean status;

        @XmlElement(name = "sustentavel", required = true)
        private boolean sustentavel;

        public Long getCodigo() {
            return codigo1;
        }

        public void setCodigo(Long codigo) {
            this.codigo1 = codigo;
        }

        public String getDescricao1() {
            return descricao;
        }

        public void setDescricao1(String descricao1) {
            this.descricao = descricao1;
        }

        public boolean isStatus1() {
            return status;
        }

        public void setStatus1(boolean status1) {
            this.status = status1;
        }

        public boolean isSustentavel1() {
            return sustentavel;
        }

        public void setSustentavel1(boolean sustentavel1) {
            this.sustentavel = sustentavel1;
        }
    }

}
