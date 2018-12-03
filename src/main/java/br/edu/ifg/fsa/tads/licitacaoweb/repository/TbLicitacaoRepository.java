package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbLicitacao;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import javax.persistence.Query;
import java.util.List;


@Repository
public class TbLicitacaoRepository extends BaseRepository {
    public List<TbLicitacao> buscarLicitacaoPorIdentificador(String identificador){
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT tb FROM TbLicitacao tb ");
        hql.append(" WHERE tb.identificador = :identificador ");


        Query query = entityManager.createQuery(hql.toString());
        query.setParameter("identificador", identificador.toString());



        return query.getResultList();

    }

    public List<TbLicitacao> buscarTodos() {
        StringBuilder hql = new StringBuilder();

        hql.append(" SELECT tb FROM TbLicitacao tb ");

        Query query = entityManager.createQuery(hql.toString());

        return query.getResultList();
    }
}
