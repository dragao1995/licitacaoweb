package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbCabecalho;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TbCabecalho entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TbCabecalhoRepository extends JpaRepository<TbCabecalho, Long> {

}
