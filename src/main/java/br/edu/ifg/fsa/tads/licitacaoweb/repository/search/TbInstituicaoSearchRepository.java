package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbInstituicao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbInstituicao entity.
 */
public interface TbInstituicaoSearchRepository extends ElasticsearchRepository<TbInstituicao, Long> {
}
