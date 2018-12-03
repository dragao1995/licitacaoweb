package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbMaterial;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the TbMaterial entity.
 */
public interface TbMaterialSearchRepository extends ElasticsearchRepository<TbMaterial, Long> {
}
