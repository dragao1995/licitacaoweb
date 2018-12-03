package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbServico;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.ServicoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TbServicoRepository extends BaseRepository{

    public List<TbServico> buscarServicoPorCodigo(Long codigo){
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT tb FROM TbServico tb ");
        hql.append(" WHERE tb.codigo = :codigo ");


        Query query = entityManager.createQuery(hql.toString());
        query.setParameter("codigo", codigo);



        return query.getResultList();

    }

    public List<TbServico> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, ServicoDTO filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT tb FROM TbServico tb ");
        sb.append(" WHERE 1=1 ");
        StringBuilder hql = montaQueryPaginada(filtro, sb);

        if (orderBy != null && StringUtils.isNotEmpty(orderBy.getField())) {
            defineOrdenacaoPaginada(orderBy, hql);
        } else {
            hql.append(" ORDER BY tb.descricao DESC");
        }


        Query query = entityManager.createQuery(hql.toString(), TbServico.class);
        definirParametrosQueryPaginada(filtro, query);
        query.setMaxResults(limite);
        query.setFirstResult((pagina - 1) * limite);
        return query.getResultList();
    }

    public Long recuperarTotal(ServicoDTO filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(1) FROM TbServico tb ");
        sb.append(" WHERE 1=1 ");
        StringBuilder hql = montaQueryPaginada(filtro, sb);
        Query query = entityManager.createQuery(hql.toString(), Long.class);
        definirParametrosQueryPaginada(filtro, query);
        return (Long) query.getSingleResult();
    }

    private StringBuilder montaQueryPaginada(ServicoDTO filtro, StringBuilder hql) {
        if (filtro.getCodigo() != null) {
            hql.append("and tb.codigo = :codigo ");
        }
        if (filtro.getDescricao() != null) {
            hql.append("and upper (tb.descricao) like upper (:descricao) ");
        }

        return hql;
    }

    private void definirParametrosQueryPaginada(ServicoDTO filtro, Query query) {
        if (filtro.getCodigo() != null) {
            query.setParameter("codigo", filtro.getCodigo());
        }
        if (filtro.getDescricao() != null) {
            query.setParameter("descricao", "%" + filtro.getDescricao().toUpperCase() + "%");
        }
    }
}
