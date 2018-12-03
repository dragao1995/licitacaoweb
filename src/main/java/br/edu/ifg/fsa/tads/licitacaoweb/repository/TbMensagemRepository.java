package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem;
import br.edu.ifg.fsa.tads.licitacaoweb.service.dto.FiltroRequisicaoDTO;
import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class TbMensagemRepository extends BaseRepository {

    public Long buscarMaxProtocolo() {
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT max(tb.protocolo) FROM TbMensagem tb ");

        Query query = entityManager.createQuery(hql.toString());

        return (Long) query.getSingleResult();

    }

    public List<TbMensagem> listaPaginada(Integer pagina, Integer limite, OrderBy orderBy, FiltroRequisicaoDTO filtro, boolean resposta) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT mensagem FROM TbMensagem mensagem ");
        if(resposta){
            sb.append("WHERE mensagem.uasgEnvio = :uasgUsuario ");
        }else {
            sb.append("WHERE mensagem.uasgDestino = :uasgUsuario ");
        }

        StringBuilder hql = montaQueryPaginada(filtro, sb);
        if (orderBy != null && StringUtils.isNotEmpty(orderBy.getField())) {
            defineOrdenacaoPaginada(orderBy, hql);
        }
        Query query = entityManager.createQuery(hql.toString(), TbMensagem.class);
        definirParametrosQueryPaginada(filtro, query);
        query.setMaxResults(limite);
        query.setFirstResult((pagina - 1) * limite);

        return query.getResultList();
    }

    public Long recuperarTotal(FiltroRequisicaoDTO filtro, boolean resposta) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT COUNT(*) FROM TbMensagem mensagem ");
        if(resposta){
            sb.append("WHERE mensagem.uasgEnvio = :uasgUsuario ");
        }else {
            sb.append("WHERE mensagem.uasgDestino = :uasgUsuario ");
        }

        StringBuilder hql = montaQueryPaginada(filtro, sb);
        Query query = entityManager.createQuery(hql.toString(), Long.class);
        definirParametrosQueryPaginada(filtro, query);
        return (Long) query.getSingleResult();
    }

    private StringBuilder montaQueryPaginada(FiltroRequisicaoDTO filtro, StringBuilder hql) {
        if (filtro.getIdentificador() != null && filtro.getIdentificador() != "") {
            hql.append("and licitacao.identificador = :identificador ");
        }
        if (filtro.getUasg() != null) {
            hql.append("and licitacao.uasg = :uasg ");
        }
        if (filtro.getUasgDescricao() != null) {
            hql.append("and upper (licitacao.uasgDescricao) like upper (:uasgDescricao) ");
        }

        if (filtro.getTipo() == "M") {

            if(filtro.getCodigo() != null)
            hql.append("and mensagem.material.codigo = :codigo ");

            if(filtro.getDescricao() != null)
                hql.append("and mensagem.material.descricao = :descricao ");

        } else if (filtro.getTipo() == "S") {

            if(filtro.getCodigo() != null)
                hql.append("and mensagem.servico.codigo = :codigo ");

            if(filtro.getDescricao() != null)
                hql.append("and mensagem.servico.descricao = :descricao ");

        }

        return hql;
    }

    private void definirParametrosQueryPaginada(FiltroRequisicaoDTO filtro, Query query) {
        if (filtro.getIdentificador() != null) {
            query.setParameter("identificador", filtro.getIdentificador());
        }

        if (filtro.getUasg() != null) {
            query.setParameter("uasg", filtro.getUasg());
        }
        if (filtro.getUasgDescricao() != null) {
            query.setParameter("uasgDescricao", "%" + filtro.getUasgDescricao().toUpperCase() + "%");
        }
        if (filtro.getCodigo() != null) {
            query.setParameter("codigo", filtro.getCodigo());
        }
        if (filtro.getDescricao() != null) {
            query.setParameter("descricao", "%" + filtro.getDescricao().toUpperCase() + "%");
        }

        if (filtro.getUasgUsuario() != null) {
            query.setParameter("uasgUsuario", filtro.getUasgUsuario());
        }

    }

}
