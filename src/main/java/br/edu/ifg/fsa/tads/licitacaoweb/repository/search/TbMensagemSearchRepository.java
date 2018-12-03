package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMensagem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbMensagem entity.
 */
public interface TbMensagemSearchRepository extends ElasticsearchRepository<TbMensagem, Long> {
}
