package com.bozzaccio.twitterclone.service;

public interface IBaseCRUDService<DTO, E, ID> {

    DTO getById(ID Id);

    DTO create(E entity);

    DTO update(E entity);

    void deleteById(ID Id);

}
