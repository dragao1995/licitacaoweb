package br.edu.ifg.fsa.tads.licitacaoweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbDocumento;

import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbDocumentoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.search.TbDocumentoSearchRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.errors.BadRequestAlertException;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing TbDocumento.
 */
@RestController
@RequestMapping("/api")
public class TbDocumentoResource {

    private final Logger log = LoggerFactory.getLogger(TbDocumentoResource.class);

    private static final String ENTITY_NAME = "tbDocumento";

    private final TbDocumentoRepository tbDocumentoRepository;

    private final TbDocumentoSearchRepository tbDocumentoSearchRepository;

    public TbDocumentoResource(TbDocumentoRepository tbDocumentoRepository, TbDocumentoSearchRepository tbDocumentoSearchRepository) {
        this.tbDocumentoRepository = tbDocumentoRepository;
        this.tbDocumentoSearchRepository = tbDocumentoSearchRepository;
    }

    /**
     * POST  /tb-documentos : Create a new tbDocumento.
     *
     * @param tbDocumento the tbDocumento to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tbDocumento, or with status 400 (Bad Request) if the tbDocumento has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-documentos")
    @Timed
    public ResponseEntity<TbDocumento> createTbDocumento(@RequestBody TbDocumento tbDocumento) throws URISyntaxException {
        log.debug("REST request to save TbDocumento : {}", tbDocumento);
        if (tbDocumento.getId() != null) {
            throw new BadRequestAlertException("A new tbDocumento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TbDocumento result = tbDocumentoRepository.save(tbDocumento);
        tbDocumentoSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/tb-documentos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-documentos : Updates an existing tbDocumento.
     *
     * @param tbDocumento the tbDocumento to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tbDocumento,
     * or with status 400 (Bad Request) if the tbDocumento is not valid,
     * or with status 500 (Internal Server Error) if the tbDocumento couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-documentos")
    @Timed
    public ResponseEntity<TbDocumento> updateTbDocumento(@RequestBody TbDocumento tbDocumento) throws URISyntaxException {
        log.debug("REST request to update TbDocumento : {}", tbDocumento);
        if (tbDocumento.getId() == null) {
            return createTbDocumento(tbDocumento);
        }
        TbDocumento result = tbDocumentoRepository.save(tbDocumento);
        tbDocumentoSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tbDocumento.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-documentos : get all the tbDocumentos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tbDocumentos in body
     */
    @GetMapping("/tb-documentos")
    @Timed
    public List<TbDocumento> getAllTbDocumentos() {
        log.debug("REST request to get all TbDocumentos");
        return tbDocumentoRepository.findAll();
        }

    /**
     * GET  /tb-documentos/:id : get the "id" tbDocumento.
     *
     * @param id the id of the tbDocumento to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tbDocumento, or with status 404 (Not Found)
     */
    @GetMapping("/tb-documentos/{id}")
    @Timed
    public ResponseEntity<TbDocumento> getTbDocumento(@PathVariable Long id) {
        log.debug("REST request to get TbDocumento : {}", id);
        TbDocumento tbDocumento = tbDocumentoRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(tbDocumento));
    }

    /**
     * DELETE  /tb-documentos/:id : delete the "id" tbDocumento.
     *
     * @param id the id of the tbDocumento to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-documentos/{id}")
    @Timed
    public ResponseEntity<Void> deleteTbDocumento(@PathVariable Long id) {
        log.debug("REST request to delete TbDocumento : {}", id);
        tbDocumentoRepository.delete(id);
        tbDocumentoSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tb-documentos?query=:query : search for the tbDocumento corresponding
     * to the query.
     *
     * @param query the query of the tbDocumento search
     * @return the result of the search
     */
    @GetMapping("/_search/tb-documentos")
    @Timed
    public List<TbDocumento> searchTbDocumentos(@RequestParam String query) {
        log.debug("REST request to search TbDocumentos for query {}", query);
        return StreamSupport
            .stream(tbDocumentoSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
