package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.ifg.fsa.tads.licitacaoweb.service.util.OrderBy;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public class BaseRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * recuperar Entidade Mapeada Por Id
     *
     * @param id com campos informados para realizar consulta
     * @param classe com campos informados para realizar consulta
     * @return objeto do tipo <T> T retornados dentro dos filtros informados
     */
    @Transactional
    public <T> T recuperarEntidadeMapeadaPorId(Long id, Class<T> classe) {
        T exemplo = entityManager.find(classe, id);
        entityManager.flush();
        entityManager.clear();
        if (exemplo == null) {
            return null;
        }
        return exemplo;
    }

    /**
     * singleResult
     *
     * @param query do JPA para realizar a consulta. Devolve nulo caso náo encontre resultado.
     */
    @SuppressWarnings("unchecked")
    @Transactional
    protected <T> T singleResult(Query query){
        List<T> result = query.getResultList();
        if(result.size() == 1 ) return result.get(0);
        if(result.size() == 0 ) return null;

        throw new RuntimeException("Multiple entities found for query");
    }



    /**
     * inserir
     *
     * @param objeto com campos informados para realizar consulta
     */
    @Transactional
    public void inserir(Object objeto) {
        entityManager.persist(objeto);
        entityManager.flush();
        entityManager.clear();
    }

    /**
     * atualizar
     *
     * @param objeto com campos informados para realizar consulta
     * @return objeto do tipo Object retornados dentro dos filtros informados
     */
    @Transactional
    public Object atualizar(Object objeto) {
        objeto = entityManager.merge(objeto);
        entityManager.flush();
        entityManager.clear();
        return objeto;
    }

    /**
     * remover
     *
     * @param objeto com campos informados para realizar consulta
     */
    @Transactional
    public void remover(Object objeto) {
        if (entityManager.contains(objeto)) {
            entityManager.remove(objeto);
        } else {
            entityManager.remove(entityManager.merge(objeto));
        }
        entityManager.flush();
        entityManager.clear();
    }



    protected Query getQuery(StringBuilder hql, Map<String, Object> parametros, int offSet, int maxResults){
        Query query = null;
        if ((offSet>=0)&&(maxResults>0)){
            query = entityManager.createQuery(hql.toString());
            query.setFirstResult(offSet);
            query.setMaxResults(maxResults);
        }
        else{
            query = entityManager.createQuery(hql.toString());
        }
        for (Map.Entry<String, Object> key : parametros.entrySet()) {
            query.setParameter(key.getKey(), key.getValue());
        }
        return query;
    }

    protected Query getQuery(StringBuilder hql, Map<String, Object> parametros){
        return this.getQuery(hql, parametros, -1, -1);
    }

    protected List getList(StringBuilder hql, Map<String, Object> parametros, int offSet, int maxResults){
        return this.getQuery(hql, parametros, offSet, maxResults).getResultList();
    }

    protected List getList(StringBuilder hql, Map<String, Object> parametros){
        return this.getList(hql, parametros, -1, -1);
    }

    protected Boolean isEmpty(StringBuilder hql, Map<String, Object> parametros, int offSet, int maxResults){
        return this.getList(hql, parametros, offSet, maxResults).isEmpty();
    }

    protected Boolean isEmpty(StringBuilder hql, Map<String, Object> parametros){
        return this.isEmpty(hql, parametros, -1, -1);
    }

    protected void defineOrdenacaoPaginada(OrderBy orderBy, StringBuilder hql) {
        if (orderBy != null && StringUtils.isNotEmpty(orderBy.getField())) {
            hql.append("order by " + orderBy.getField() + " " + orderBy.getType());
        }
    }
}
