package com.bozzaccio.twitterclone.controller;

import com.bozzaccio.twitterclone.entity.BaseEntity;
import com.bozzaccio.twitterclone.service.BaseCRUDServiceImpl;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import static com.bozzaccio.twitterclone.utils.ErrorUtils.*;

public class AbstractRESTController<DTO, E extends BaseEntity<ID>, ID, S extends BaseCRUDServiceImpl<DTO, E, ID>> {

    protected final S service;

    public AbstractRESTController(S service) {
        Assert.notNull(service, buildErrorMessage(BASE_INITIALIZATION_ERROR, SERVICE, NULL_MESSAGE_ERROR));
        this.service = service;
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

    @PostMapping
    public DTO create(@RequestBody DTO dto) {
        return service.create(service.converter.convertDTO(dto));
    }

    @PutMapping
    public DTO update(@RequestBody DTO dto) {
        return service.create(service.converter.convertDTO(dto));
    }

}
