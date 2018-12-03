package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbPessoa;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbPessoa entity.
 */
public interface TbPessoaSearchRepository extends ElasticsearchRepository<TbPessoa, Long> {
}
