package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbDocumento;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbDocumento entity.
 */
public interface TbDocumentoSearchRepository extends ElasticsearchRepository<TbDocumento, Long> {
}
