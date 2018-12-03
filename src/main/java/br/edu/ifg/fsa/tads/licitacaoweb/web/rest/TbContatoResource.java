package br.edu.ifg.fsa.tads.licitacaoweb.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.edu.ifg.fsa.tads.licitacaoweb.domain.TbContato;

import br.edu.ifg.fsa.tads.licitacaoweb.repository.TbContatoRepository;
import br.edu.ifg.fsa.tads.licitacaoweb.repository.search.TbContatoSearchRepository;
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
 * REST controller for managing TbContato.
 */
@RestController
@RequestMapping("/api")
public class TbContatoResource {

    private final Logger log = LoggerFactory.getLogger(TbContatoResource.class);

    private static final String ENTITY_NAME = "tbContato";

    private final TbContatoRepository tbContatoRepository;

    private final TbContatoSearchRepository tbContatoSearchRepository;

    public TbContatoResource(TbContatoRepository tbContatoRepository, TbContatoSearchRepository tbContatoSearchRepository) {
        this.tbContatoRepository = tbContatoRepository;
        this.tbContatoSearchRepository = tbContatoSearchRepository;
    }

    /**
     * POST  /tb-contatoes : Create a new tbContato.
     *
     * @param tbContato the tbContato to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tbContato, or with status 400 (Bad Request) if the tbContato has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-contatoes")
    @Timed
    public ResponseEntity<TbContato> createTbContato(@Valid @RequestBody TbContato tbContato) throws URISyntaxException {
        log.debug("REST request to save TbContato : {}", tbContato);
        if (tbContato.getId() != null) {
            throw new BadRequestAlertException("A new tbContato cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TbContato result = tbContatoRepository.save(tbContato);
        tbContatoSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/tb-contatoes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-contatoes : Updates an existing tbContato.
     *
     * @param tbContato the tbContato to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tbContato,
     * or with status 400 (Bad Request) if the tbContato is not valid,
     * or with status 500 (Internal Server Error) if the tbContato couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-contatoes")
    @Timed
    public ResponseEntity<TbContato> updateTbContato(@Valid @RequestBody TbContato tbContato) throws URISyntaxException {
        log.debug("REST request to update TbContato : {}", tbContato);
        if (tbContato.getId() == null) {
            return createTbContato(tbContato);
        }
        TbContato result = tbContatoRepository.save(tbContato);
        tbContatoSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tbContato.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-contatoes : get all the tbContatoes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tbContatoes in body
     */
    @GetMapping("/tb-contatoes")
    @Timed
    public List<TbContato> getAllTbContatoes() {
        log.debug("REST request to get all TbContatoes");
        return tbContatoRepository.findAll();
        }

    /**
     * GET  /tb-contatoes/:id : get the "id" tbContato.
     *
     * @param id the id of the tbContato to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tbContato, or with status 404 (Not Found)
     */
    @GetMapping("/tb-contatoes/{id}")
    @Timed
    public ResponseEntity<TbContato> getTbContato(@PathVariable Long id) {
        log.debug("REST request to get TbContato : {}", id);
        TbContato tbContato = tbContatoRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(tbContato));
    }

    /**
     * DELETE  /tb-contatoes/:id : delete the "id" tbContato.
     *
     * @param id the id of the tbContato to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-contatoes/{id}")
    @Timed
    public ResponseEntity<Void> deleteTbContato(@PathVariable Long id) {
        log.debug("REST request to delete TbContato : {}", id);
        tbContatoRepository.delete(id);
        tbContatoSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tb-contatoes?query=:query : search for the tbContato corresponding
     * to the query.
     *
     * @param query the query of the tbContato search
     * @return the result of the search
     */
    @GetMapping("/_search/tb-contatoes")
    @Timed
    public List<TbContato> searchTbContatoes(@RequestParam String query) {
        log.debug("REST request to search TbContatoes for query {}", query);
        return StreamSupport
            .stream(tbContatoSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
