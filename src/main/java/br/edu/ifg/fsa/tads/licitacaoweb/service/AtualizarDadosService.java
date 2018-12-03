package br.edu.ifg.fsa.tads.licitacaoweb.service;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbItem;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbLicitacao;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbServico;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbItemRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbLicitacaoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbMaterialRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbServicoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.service.XML.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class AtualizarDadosService {

    @Autowired
    TbMaterialRepository tbMaterialRepository;

    @Autowired
    TbServicoRepository tbServicoRepository;

    @Autowired
    TbLicitacaoRepository tbLicitacaoRepository;

    @Autowired
    TbItemRepository tbItemRepository;

    @Transactional
    public void atualizarDados() throws UnsupportedEncodingException, JAXBException {

//        material


        MaterialXML.Embedded materiais = new MaterialXML.Embedded();
        materiais.setResources(new ArrayList<>());
        boolean b = true;
        Long offset = 300000L;
        while (b) {
            MaterialXML auxMateriais = buscaMaterial(offset);

            if (auxMateriais.getEmbeddeds().getResources().size() != 500) {
                b = false;
            }
            offset = offset + 500;
            materiais.getResources().addAll(auxMateriais.getEmbeddeds().getResources());
        }

        for (MaterialXML.Resource m : materiais.getResources()) {

            List<TbMaterial> tbMaterials = tbMaterialRepository.buscarMaterialPorCodigo(m.getCodigo());

            TbMaterial material = new TbMaterial();

            if (tbMaterials.size() != 0) {
                material = tbMaterials.get(0);
            }

            material.setCodigo(m.getCodigo());
            String s = m.getDescricao1();
            material.setDescricao(s.replaceAll("\\s+", " "));
            material.setStatus(m.isStatus1());
            material.setSustentavel(m.isSustentavel1());

            if (tbMaterials.size() == 0) {
                tbMaterialRepository.inserir(material);

            } else {
                tbMaterialRepository.atualizar(material);

            }

        }

        //        servico
        ServicoXML.Embedded servicos = new ServicoXML.Embedded();
        servicos.setResources(new ArrayList<>());
        b = true;
        offset = 0L;
        while (b) {
            ServicoXML auxServicos = buscaServico(offset);

            if (auxServicos.getEmbeddeds().getResources().size() != 500) {
                b = false;
            }
            offset = offset + 500;
            servicos.getResources().addAll(auxServicos.getEmbeddeds().getResources());
        }

        for (ServicoXML.Resource s : servicos.getResources()) {

            List<TbServico> tbServicos = tbServicoRepository.buscarServicoPorCodigo(s.getCodigo());

            TbServico servico = new TbServico();

            if (tbServicos.size() != 0) {
                servico = tbServicos.get(0);
            }
            servico.setCodigo(s.getCodigo());
            servico.setCpc(s.getCpc());
            servico.setDescricao(s.getDescricao());
            servico.setUnidadeMedida(s.getUnidade_medida());

            if (tbServicos.size() == 0) {
                tbServicoRepository.inserir(servico);

            } else {
                tbServicoRepository.atualizar(servico);

            }

        }


        //        licitação
        LicitacaoXML.Embedded licitacaos = new LicitacaoXML.Embedded();
        licitacaos.setResources1(new ArrayList<>());
        b = true;
        offset = 0L;
        List<String> uasgss = new ArrayList<>();
        uasgss.add("158153");
//        uasgss.add("158640");
        uasgss.add("158522");
        uasgss.add("158610");
        uasgss.add("158611");
        uasgss.add("158523");//fsa
        uasgss.add("158430");
//        uasgss.add("158641");
        uasgss.add("158432");
        uasgss.add("158433");
        uasgss.add("158431");
        uasgss.add("158524");
//        uasgss.add("155642");
        uasgss.add("158434");
//        uasgss.add("158643");

        for (String ss : uasgss) {

            offset = 0L;
            b = true;

            while (b) {
                LicitacaoXML auxLicitacao = buscaLicitacao(ss);

                if (auxLicitacao.getEmbeddeds().getResources1().size() != 500) {
                    b = false;
                }
                offset = offset + 500;
                licitacaos.getResources1().addAll(auxLicitacao.getEmbeddeds().getResources1());
            }
        }

        for (LicitacaoXML.Resource l : licitacaos.getResources1()) {

            List<TbLicitacao> tbLicitacao = tbLicitacaoRepository.buscarLicitacaoPorIdentificador(l.getIdentificador1());

            TbLicitacao licitacao = new TbLicitacao();

            if (tbLicitacao.size() != 0) {
                licitacao = tbLicitacao.get(0);
            }

            licitacao.setIdentificador(l.getIdentificador1());
            licitacao.setUasg(l.getUasg1());
            licitacao.setModalidade(l.getModalidade1().intValue());
            //licitacao.setNumero_aviso1();
            licitacao.setSituacaoAviso(l.getSituacao_aviso1());
            licitacao.setObjeto(l.getObjeto1() + "");
            licitacao.setInformcoesGerais(l.getInformacoes_gerais1());
            if (l.getNumero_processo1() != null)
                licitacao.setNumeroProcesso(l.getNumero_processo1());
            licitacao.setTipoRecurso(l.getTipo_recurso1());
            licitacao.setNumeroItens(l.getNumero_aviso1());
            licitacao.setNomeResponsavel(l.getNome_responsavel1());
            licitacao.setFuncaoResponsavel(l.getFuncao_responsavel1());
            if (l.getData_entrega_edital1() != null)
                licitacao.setDataEntregaedital(l.getData_entrega_edital1().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            licitacao.setEnderecoEntregaEdital(l.getEndereco_entrega_edital1());
            if (l.getData_entrega_proposta1() != null)
                licitacao.setDataEntregaProposta(l.getData_entrega_proposta1().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            if (l.getData_publicacao1() != null)
                licitacao.setDataPublicacao(l.getData_publicacao1().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            licitacao.setUasgDescricao(buscaUasg(l.getUasg1().toString()).getNome());

            if (tbLicitacao.size() == 0) {
                tbServicoRepository.inserir(licitacao);
            } else {
                tbServicoRepository.atualizar(licitacao);
            }

        }


        //        itens
        List<TbLicitacao> listaTbLicitacao = tbLicitacaoRepository.buscarTodos();
        ListaItensXML.Embedded itens = new ListaItensXML.Embedded();
        itens.setResources(new ArrayList<>());
        b = true;
        offset = 0L;

        for (TbLicitacao ll : listaTbLicitacao) {

            offset = 0L;
            b = true;

            while (b) {
                ListaItensXML auxItens = buscaItens(ll.getIdentificador(), offset);

                if (auxItens.getEmbeddeds().getResources() == null) {
                    b = false;
                }else if (auxItens.getEmbeddeds().getResources().size() != 500) {
                    itens.getResources().addAll(auxItens.getEmbeddeds().getResources());
                    b = false;
                }
                offset = offset + 500;

            }
        }


        for (ListaItensXML.Resource li : itens.getResources()) {

            List<TbItem> tbItems = tbItemRepository.buscarLicitacaoPorItem(li);

            TbItem item = new TbItem();

            if (tbItems.size() != 0) {
                item = tbItems.get(0);
            }

            item.setLicitacao(tbLicitacaoRepository.buscarLicitacaoPorIdentificador(li.getNumero_licitacao()).get(0));
            if (li.getCodigo_item_material() != null)
                item.setMaterial(tbMaterialRepository.buscarMaterialPorCodigo(li.getCodigo_item_material()).get(0));
            if (li.getCodigo_item_servico() != null)
                item.setServico(tbServicoRepository.buscarServicoPorCodigo(li.getCodigo_item_servico()).get(0));
            item.setUasg(li.getUasg());
            item.setCodigoItemMaterial(li.getCodigo_item_material());
            item.setCodigoItemServico(li.getCodigo_item_servico());
            item.setDescricaoItem(li.getDescricao_item());
            item.setNumeroLicitacao(li.getNumero_licitacao());
            item.setQuantidade(li.getCodigo_item_material());

            if (tbItems.size() == 0) {
                tbServicoRepository.inserir(item);
            } else {
                tbServicoRepository.atualizar(item);
            }

        }


    }

    public static MaterialXML buscaMaterial(Long offset) throws JAXBException {
        WebResource wr;
        Client c = Client.create();

        wr = c.resource("http://compras.dados.gov.br/materiais/v1/materiais.xml?offset=" + offset.toString());

        InputStream is = null;
        try {
            String s = wr.get(String.class);
            is = new ByteArrayInputStream(s.getBytes("UTF-8"));
        } catch (Exception e) {
            MaterialXML materialXML = new MaterialXML();
            materialXML.setEmbeddeds(new MaterialXML.Embedded());
            materialXML.getEmbeddeds().setResources(new ArrayList<>());
            return materialXML;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(MaterialXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (MaterialXML) unmarshaller.unmarshal(is);
    }

    public static ServicoXML buscaServico(Long offset) throws JAXBException {
        WebResource wr;
        Client c = Client.create();

        wr = c.resource("http://compras.dados.gov.br/servicos/v1/servicos.xml?offset=" + offset.toString());

        InputStream is = null;
        try {
            String s = wr.get(String.class);
            is = new ByteArrayInputStream(s.getBytes("UTF-8"));
        } catch (Exception e) {
            ServicoXML servicoXML = new ServicoXML();
            servicoXML.setEmbeddeds(new ServicoXML.Embedded());
            servicoXML.getEmbeddeds().setResources(new ArrayList<>());
            return servicoXML;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(ServicoXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (ServicoXML) unmarshaller.unmarshal(is);
    }

    public static LicitacaoXML buscaLicitacao(String uasg) throws JAXBException {
        WebResource wr;
        Client c = Client.create();

        wr = c.resource("http://compras.dados.gov.br/licitacoes/v1/licitacoes.xml?uasg=" + uasg);

        InputStream is = null;
        try {
            String s = wr.get(String.class);
            is = new ByteArrayInputStream(s.getBytes("UTF-8"));
        } catch (Exception e) {
            LicitacaoXML licitacaoXML = new LicitacaoXML();
            licitacaoXML.setEmbeddeds(new LicitacaoXML.Embedded());
            licitacaoXML.getEmbeddeds().setResources1(new ArrayList<>());
            return licitacaoXML;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(LicitacaoXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (LicitacaoXML) unmarshaller.unmarshal(is);
    }

    public static ListaItensXML buscaItens(String numeroLicitacao, Long offset) throws JAXBException {
        WebResource wr;
        Client c = Client.create();

        wr = c.resource("http://compras.dados.gov.br/licitacoes/doc/licitacao/" + numeroLicitacao + "/itens.xml?offset=" + offset);

        InputStream is = null;
        try {
            String s = wr.get(String.class);
            is = new ByteArrayInputStream(s.getBytes("UTF-8"));
        } catch (Exception e) {
            ListaItensXML listaItensXML = new ListaItensXML();
            listaItensXML.setEmbeddeds(new ListaItensXML.Embedded());
            listaItensXML.getEmbeddeds().setResources(new ArrayList<>());
            return listaItensXML;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(ListaItensXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (ListaItensXML) unmarshaller.unmarshal(is);
    }

    public static UasgXML buscaUasg(String uasg) throws JAXBException {
        WebResource wr;
        Client c = Client.create();

        wr = c.resource("http://compras.dados.gov.br/licitacoes/doc/uasg/"+uasg+".xml");

        InputStream is = null;
        try {
            String s = wr.get(String.class);
            is = new ByteArrayInputStream(s.getBytes("UTF-8"));
        } catch (Exception e) {

        }

        JAXBContext jaxbContext = JAXBContext.newInstance(UasgXML.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (UasgXML) unmarshaller.unmarshal(is);
    }
}
