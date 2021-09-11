package com.bozzaccio.twitterclone.service;

import com.bozzaccio.twitterclone.dto.AbstractConverter;
import com.bozzaccio.twitterclone.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static com.bozzaccio.twitterclone.utils.ErrorUtils.*;

public abstract class BaseCRUDServiceImpl<DTO, E extends BaseEntity<ID>, ID> implements IBaseCRUDService<DTO, E, ID> {

    protected final JpaRepository<E, ID> repository;
    public final AbstractConverter<DTO, E> converter;

    public BaseCRUDServiceImpl(JpaRepository<E, ID> repository,
                               AbstractConverter<DTO, E> converter) {

        Assert.notNull(repository, buildErrorMessage(BASE_INITIALIZATION_ERROR, DAO, NULL_MESSAGE_ERROR));
        this.repository = repository;

        Assert.notNull(repository, buildErrorMessage(BASE_INITIALIZATION_ERROR, CONVERTER, NULL_MESSAGE_ERROR));
        this.converter = converter;
    }


    @Override
    @Transactional(readOnly = true)
    public DTO getById(ID Id) {

        Assert.notNull(Id, buildErrorMessage(BASE_PARAMETER_ERROR, ID_PARAM, NULL_MESSAGE_ERROR));
        Optional<E> entity = repository.findById(Id);

        if (entity.isPresent()) {
            return converter.convertEntity(entity.get());
        } else {
            throw new EntityNotFoundException(
                    buildErrorMessageWithValue(BASE_DB_ERROR, ENTITY_NOT_FOUND_FOR_ID_ERROR, Id));
        }
    }

    @Override
    @Transactional
    public void deleteById(ID Id) {

        Assert.notNull(Id, buildErrorMessage(BASE_PARAMETER_ERROR, ID_PARAM, NULL_MESSAGE_ERROR));

        try {
            repository.deleteById(Id);
        } catch (Exception e) {
            throw new EntityNotFoundException(
                    buildErrorMessageWithValue(BASE_DB_ERROR, ENTITY_NOT_FOUND_FOR_ID_ERROR, Id));
        }
    }

    @Override
    @Transactional
    public DTO update(E entity) {

        Assert.notNull(entity, buildErrorMessage(BASE_PARAMETER_ERROR, ENTITY, NULL_MESSAGE_ERROR));
        Assert.notNull(entity.getId(), buildErrorMessage(BASE_PARAMETER_ERROR, ID_PARAM, NULL_MESSAGE_ERROR));

        E savedEntity = repository.saveAndFlush(entity);
        return converter.convertEntity(savedEntity);
    }

    @Override
    @Transactional
    public DTO create(E entity) {

        Assert.notNull(entity, buildErrorMessage(BASE_PARAMETER_ERROR, ENTITY, NULL_MESSAGE_ERROR));

        E savedEntity = repository.saveAndFlush(entity);
        return converter.convertEntity(savedEntity);
    }
}
