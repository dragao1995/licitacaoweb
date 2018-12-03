package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbLicitacao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbLicitacao entity.
 */
public interface TbLicitacaoSearchRepository extends ElasticsearchRepository<TbLicitacao, Long> {
}
