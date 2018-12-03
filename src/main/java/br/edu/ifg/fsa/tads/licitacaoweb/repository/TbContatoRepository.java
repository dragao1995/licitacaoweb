package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbContato;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TbContato entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TbContatoRepository extends JpaRepository<TbContato, Long> {

}
