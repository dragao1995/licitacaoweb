package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbItem;
import br.edu.ifg.fsa.tads.licitacaoweb.service.XML.ListaItensXML;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import javax.persistence.Query;
import java.util.List;


@Repository
public class TbItemRepository extends BaseRepository {


    public List<TbItem> buscarLicitacaoPorItem(ListaItensXML.Resource li) {
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT tb FROM TbItem tb ");
        hql.append(" WHERE tb.numeroLicitacao = :numeroLicitacao ");
        if(li.getCodigo_item_material()!=null)
        hql.append(" AND tb.codigoItemMaterial = :codigoItemMaterial ");
        if(li.getCodigo_item_servico()!=null)
        hql.append(" AND tb.codigoItemServico = :codigoItemServico ");

        Query query = entityManager.createQuery(hql.toString());
        query.setParameter("numeroLicitacao", li.getNumero_licitacao());
        if(li.getCodigo_item_material()!=null)
        query.setParameter("codigoItemMaterial", li.getCodigo_item_material());
        if(li.getCodigo_item_servico()!=null)
        query.setParameter("codigoItemServico", li.getCodigo_item_servico());

        return query.getResultList();
    }
}
