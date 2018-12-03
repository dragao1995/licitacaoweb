package br.edu.ifg.fsa.tads.licitacaoweb.repository.search;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {
}
