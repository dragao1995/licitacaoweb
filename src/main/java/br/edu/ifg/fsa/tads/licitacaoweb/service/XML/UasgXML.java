package br.edu.ifg.fsa.tads.licitacaoweb.service.XML;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "resource")
public class UasgXML {

    @XmlElement(name = "nome", required = true)
    String nome1;

    @XmlElement(name = "nome_mnemonico", required = true)
    String nome_mnemonico1;

    public String getNome() {
        return nome1;
    }

    public void setNome(String nome) {
        this.nome1 = nome;
    }

    public String getNome_mnemonico() {
        return nome_mnemonico1;
    }

    public void setNome_mnemonico(String nome_mnemonico) {
        this.nome_mnemonico1 = nome_mnemonico;
    }
}
