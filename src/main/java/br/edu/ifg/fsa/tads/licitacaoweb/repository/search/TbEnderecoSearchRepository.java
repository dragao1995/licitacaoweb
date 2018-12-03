package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbEndereco;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbEndereco entity.
 */
public interface TbEnderecoSearchRepository extends ElasticsearchRepository<TbEndereco, Long> {
}
