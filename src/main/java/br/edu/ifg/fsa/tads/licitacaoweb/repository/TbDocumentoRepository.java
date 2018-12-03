package br.edu.ifg.fsa.tads.licitacaoweb.repository;

import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbDocumento;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TbDocumento entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TbDocumentoRepository extends JpaRepository<TbDocumento, Long> {

}
