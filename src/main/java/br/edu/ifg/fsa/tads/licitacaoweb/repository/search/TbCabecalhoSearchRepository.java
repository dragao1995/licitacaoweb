package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbCabecalho;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbCabecalho entity.
 */
public interface TbCabecalhoSearchRepository extends ElasticsearchRepository<TbCabecalho, Long> {
}
