package br.edu.ifg.fsa.tads.licitacaoweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbCabecalho;

import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbCabecalhoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.search.TbCabecalhoSearchRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.errors.BadRequestAlertException;
import br.edu.ifg.fsa.tads.licitacaoweb.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing TbCabecalho.
 */
@RestController
@RequestMapping("/api")
public class TbCabecalhoResource {

    private final Logger log = LoggerFactory.getLogger(TbCabecalhoResource.class);

    private static final String ENTITY_NAME = "tbCabecalho";

    private final TbCabecalhoRepository tbCabecalhoRepository;

    private final TbCabecalhoSearchRepository tbCabecalhoSearchRepository;

    public TbCabecalhoResource(TbCabecalhoRepository tbCabecalhoRepository, TbCabecalhoSearchRepository tbCabecalhoSearchRepository) {
        this.tbCabecalhoRepository = tbCabecalhoRepository;
        this.tbCabecalhoSearchRepository = tbCabecalhoSearchRepository;
    }

    /**
     * POST  /tb-cabecalhos : Create a new tbCabecalho.
     *
     * @param tbCabecalho the tbCabecalho to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tbCabecalho, or with status 400 (Bad Request) if the tbCabecalho has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-cabecalhos")
    @Timed
    public ResponseEntity<TbCabecalho> createTbCabecalho(@Valid @RequestBody TbCabecalho tbCabecalho) throws URISyntaxException {
        log.debug("REST request to save TbCabecalho : {}", tbCabecalho);
        if (tbCabecalho.getId() != null) {
            throw new BadRequestAlertException("A new tbCabecalho cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TbCabecalho result = tbCabecalhoRepository.save(tbCabecalho);
        tbCabecalhoSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/tb-cabecalhos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-cabecalhos : Updates an existing tbCabecalho.
     *
     * @param tbCabecalho the tbCabecalho to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tbCabecalho,
     * or with status 400 (Bad Request) if the tbCabecalho is not valid,
     * or with status 500 (Internal Server Error) if the tbCabecalho couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-cabecalhos")
    @Timed
    public ResponseEntity<TbCabecalho> updateTbCabecalho(@Valid @RequestBody TbCabecalho tbCabecalho) throws URISyntaxException {
        log.debug("REST request to update TbCabecalho : {}", tbCabecalho);
        if (tbCabecalho.getId() == null) {
            return createTbCabecalho(tbCabecalho);
        }
        TbCabecalho result = tbCabecalhoRepository.save(tbCabecalho);
        tbCabecalhoSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tbCabecalho.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-cabecalhos : get all the tbCabecalhos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tbCabecalhos in body
     */
    @GetMapping("/tb-cabecalhos")
    @Timed
    public List<TbCabecalho> getAllTbCabecalhos() {
        log.debug("REST request to get all TbCabecalhos");
        return tbCabecalhoRepository.findAll();
        }

    /**
     * GET  /tb-cabecalhos/:id : get the "id" tbCabecalho.
     *
     * @param id the id of the tbCabecalho to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tbCabecalho, or with status 404 (Not Found)
     */
    @GetMapping("/tb-cabecalhos/{id}")
    @Timed
    public ResponseEntity<TbCabecalho> getTbCabecalho(@PathVariable Long id) {
        log.debug("REST request to get TbCabecalho : {}", id);
        TbCabecalho tbCabecalho = tbCabecalhoRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(tbCabecalho));
    }

    /**
     * DELETE  /tb-cabecalhos/:id : delete the "id" tbCabecalho.
     *
     * @param id the id of the tbCabecalho to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-cabecalhos/{id}")
    @Timed
    public ResponseEntity<Void> deleteTbCabecalho(@PathVariable Long id) {
        log.debug("REST request to delete TbCabecalho : {}", id);
        tbCabecalhoRepository.delete(id);
        tbCabecalhoSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tb-cabecalhos?query=:query : search for the tbCabecalho corresponding
     * to the query.
     *
     * @param query the query of the tbCabecalho search
     * @return the result of the search
     */
    @GetMapping("/_search/tb-cabecalhos")
    @Timed
    public List<TbCabecalho> searchTbCabecalhos(@RequestParam String query) {
        log.debug("REST request to search TbCabecalhos for query {}", query);
        return StreamSupport
            .stream(tbCabecalhoSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
