package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbPessoa;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TbPessoa entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TbPessoaRepository extends JpaRepository<TbPessoa, Long> {

}
