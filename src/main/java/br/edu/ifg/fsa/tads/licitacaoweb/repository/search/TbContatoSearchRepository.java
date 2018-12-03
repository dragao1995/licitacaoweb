package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbContato;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbContato entity.
 */
public interface TbContatoSearchRepository extends ElasticsearchRepository<TbContato, Long> {
}
