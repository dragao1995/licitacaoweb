package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.MaterialDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TbMaterialRepository extends BaseRepository {


    public List<TbMaterial> buscarMaterialPorCodigo(Long codigo){
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT tb FROM TbMaterial tb ");
        hql.append(" WHERE tb.codigo = :codigo ");


        Query query = entityManager.createQuery(hql.toString());
        query.setParameter("codigo", codigo);



        return query.getResultList();

    }

    public List<TbMaterial> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, MaterialDTO filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT tb FROM TbMaterial tb ");
        sb.append(" WHERE 1=1 ");
        StringBuilder hql = montaQueryPaginada(filtro, sb);
        if (orderBy != null && StringUtils.isNotEmpty(orderBy.getField())) {
            defineOrdenacaoPaginada(orderBy, hql);
        } else {
            hql.append(" ORDER BY tb.descricao DESC");
        }
        Query query = entityManager.createQuery(hql.toString(), TbMaterial.class);
        definirParametrosQueryPaginada(filtro, query);
        query.setMaxResults(limite);
        query.setFirstResult((pagina - 1) * limite);
        return query.getResultList();
    }

    public Long recuperarTotal(MaterialDTO filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(1) FROM TbMaterial tb ");
        sb.append(" WHERE 1=1 ");
        StringBuilder hql = montaQueryPaginada(filtro, sb);
        Query query = entityManager.createQuery(hql.toString(), Long.class);
        definirParametrosQueryPaginada(filtro, query);
        return (Long) query.getSingleResult();
    }

    private StringBuilder montaQueryPaginada(MaterialDTO filtro, StringBuilder hql) {
        if (filtro.getCodigo() != null) {
            hql.append("and tb.codigo = :codigo ");
        }
        if (filtro.getDescricao() != null) {
            hql.append("and upper (tb.descricao) like upper (:descricao) ");
        }

        return hql;
    }

    private void definirParametrosQueryPaginada(MaterialDTO filtro, Query query) {
        if (filtro.getCodigo() != null) {
            query.setParameter("codigo", filtro.getCodigo());
        }
        if (filtro.getDescricao() != null) {
            query.setParameter("descricao", "%" + filtro.getDescricao().toUpperCase() + "%");
        }
    }

}
