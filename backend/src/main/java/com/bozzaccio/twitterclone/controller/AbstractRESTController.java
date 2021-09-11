package com.bozzaccio.twitterclone.controller;

import com.bozzaccio.twitterclone.entity.BaseEntity;
import com.bozzaccio.twitterclone.service.BaseCRUDServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import static com.bozzaccio.twitterclone.util.ErrorUtils.*;

public class AbstractRESTController<DTO, E extends BaseEntity<ID>, ID, S extends BaseCRUDServiceImpl<DTO, E, ID>> {

    protected final S service;

    public AbstractRESTController(S service) {
        Assert.notNull(service, buildErrorMessage(BASE_INITIALIZATION_ERROR, SERVICE, NULL_MESSAGE_ERROR));
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable ID id) {

        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ID id) {

        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {

        try {
            return ResponseEntity.ok(service.create(service.converter.convertDTO(dto)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<DTO> update(@RequestBody DTO dto) {

        try {
            return ResponseEntity.ok(service.create(service.converter.convertDTO(dto)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
