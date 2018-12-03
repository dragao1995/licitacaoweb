package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbItem;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.LicitacaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class LicitacaoRepository extends BaseRepository {


    public List<TbItem> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, LicitacaoDTO filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT item FROM TbItem item ");

        if (filtro.getCodigoMaterial() != null) {
            sb.append("WHERE item.codigoItemMaterial = :codigoMaterial ");
        } else if (filtro.getCodigoServico() != null) {
            sb.append("WHERE item.codigoItemServico = :codigoServico ");
        }
        StringBuilder hql = montaQueryPaginada(filtro, sb);
        if (orderBy != null && StringUtils.isNotEmpty(orderBy.getField())) {
            defineOrdenacaoPaginada(orderBy, hql);
        } else {
            hql.append(" ORDER BY licitacao.numeroProcesso DESC");
        }
        Query query = entityManager.createQuery(hql.toString(), TbItem.class);
        definirParametrosQueryPaginada(filtro, query);
        query.setMaxResults(limite);
        query.setFirstResult((pagina - 1) * limite);

        return query.getResultList();
    }

    public Long recuperarTotal(LicitacaoDTO filtro) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) FROM TbItem item ");

        if (filtro.getCodigoMaterial() != null) {
            sb.append("WHERE item.codigoItemMaterial = :codigoMaterial ");
        } else if (filtro.getCodigoServico() != null) {
            sb.append("WHERE item.codigoItemServico = :codigoServico ");
        }
        StringBuilder hql = montaQueryPaginada(filtro, sb);
        Query query = entityManager.createQuery(hql.toString(), Long.class);
        definirParametrosQueryPaginada(filtro, query);
        return (Long) query.getSingleResult();
    }

    private StringBuilder montaQueryPaginada(LicitacaoDTO filtro, StringBuilder hql) {
        if (filtro.getIdentificador() != null && filtro.getIdentificador() != "") {
            hql.append("and licitacao.identificador = :identificador ");
        }
        if (filtro.getNumeroProcesso() != null) {
            hql.append("and licitacao.numeroProcesso = :numeroProcesso ");
        }
        if (filtro.getUasg() != null) {
            hql.append("and licitacao.uasg = :uasg ");
        }
        if (filtro.getUasgDescricao() != null) {
            hql.append("and upper (licitacao.uasgDescricao) like upper (:uasgDescricao) ");
        }

        return hql;
    }

    private void definirParametrosQueryPaginada(LicitacaoDTO filtro, Query query) {
        if (filtro.getIdentificador() != null) {
            query.setParameter("identificador", filtro.getIdentificador());
        }
        if (filtro.getNumeroProcesso() != null) {
            query.setParameter("numeroProcesso", filtro.getNumeroProcesso());
        }
        if (filtro.getUasg() != null) {
            query.setParameter("uasg", filtro.getUasg());
        }
        if (filtro.getUasgDescricao() != null) {
            query.setParameter("uasgDescricao", "%" + filtro.getUasgDescricao().toUpperCase() + "%");
        }
        if (filtro.getCodigoMaterial() != null) {
            query.setParameter("codigoMaterial", filtro.getCodigoMaterial());
        }
        if (filtro.getCodigoServico() != null) {
            query.setParameter("codigoServico", filtro.getCodigoServico());
        }

    }


    //EXEMPLO DE CONSULTAS
    /*
    private Boolean buscarCertidaoDiferentePendente(FiltroPesquisaEmitirCertidaoDTO filtro){
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT lancamento FROM TbLancamento lancamento ");
        hql.append(" LEFT JOIN FETCH lancamento.receita receita ");
        hql.append(" LEFT JOIN FETCH lancamento.situacaoLancamento situacaoLancamento ");
        hql.append(" WHERE lancamento.cpfCnpj = :cpfCnpj ");
        hql.append(" AND receita.notificacaoReceita = 1 ");
        hql.append(" AND situacaoLancamento.descricao <> 'PENDENTE' ");

        if(filtro.getFistel() != null){
            hql.append(" AND lancamento.nuFistel = :idFistel ");
        }
        Query query = this.entityManager.createQuery(hql.toString());
        query.setParameter("cpfCnpj", filtro.getCpfCnpj());

        if(filtro.getFistel() != null){query.setParameter("idFistel", filtro.getFistel().toString());}
        Boolean resultado = !query.getResultList().isEmpty();

        return resultado;

    }
    */

    /*
    public TbGestorCreditoGestorCobranca consultarGestorCreditor(Long id) {

        StringBuilder hql = new StringBuilder();
        Map<String, Object> parametros = new HashMap<>();

        hql.append(" SELECT gestorCredito FROM TbGestorCreditoGestorCobranca gestorCredito ");
        hql.append(" LEFT JOIN FETCH gestorCredito.tbGestorCredito credito ");
        hql.append(" LEFT JOIN FETCH gestorCredito.tbGestorCobranca cobranca ");
        hql.append(" WHERE 1 = 1 ");

        if (id != null) {
            hql.append(" AND credito.situacao = 1 ");
            hql.append(" AND cobranca.id IN :id ");
            parametros.put("id", id);
        }

        Query query = entityManager.createQuery(hql.toString());
        for (Map.Entry<String, Object> key : parametros.entrySet()) {
            query.setParameter(key.getKey(), key.getValue());
        }

        List<TbGestorCreditoGestorCobranca> result = query.getResultList();
        if(result.isEmpty()) return null;
        else return result.get(0);
    }
    */

    /*
    public List<TbContextoParcelamento> pesquisarContextosPorTipoEParcelamentoGrupoReceita(Long idParcelamentoGrupoReceita, Long tipoContexto){
        StringBuilder hql = new StringBuilder();
        Map<String, Object> parametros = new HashMap<String, Object>();
        hql.append("SELECT distinct(cp) ")
            .append(" FROM TbContextoParcelamento cp ")
            .append("	INNER JOIN FETCH cp.situacaoContextoParcelamento scp ")
            .append("	INNER JOIN FETCH cp.parcelamentoGrupoReceita pgr ")
            .append("	INNER JOIN FETCH cp.parcelas parcelas ")
            .append(" WHERE pgr.id = :idParcelamento and cp.tipoContextoParcelamento.id = :tipoContexto ");

        parametros.put("idParcelamento", idParcelamentoGrupoReceita);
        parametros.put("tipoContexto", tipoContexto);

        Query query = entityManager.createQuery(hql.toString());

        for (Map.Entry<String, Object> key : parametros.entrySet()) {
            query.setParameter(key.getKey(), key.getValue());
        }

        List<TbContextoParcelamento> listaRetorno = query.getResultList();

        return query.getResultList();
    }
    */

}
