package com.spiashko.rsqlexample.crudbase;

import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseSearchService<E extends BaseJournalEntity> {

    List<E> findAll();

    List<E> findAll(Specification<E> spec);

    <T> List<T> findAll(Class<T> clazz);

    <T> List<T> findAll(Class<T> clazz, Specification<E> spec);

    Optional<E> findOne(UUID id);

    Optional<E> findOne(Specification<E> spec);

    <T> Optional<T> findOne(UUID id, Class<T> clazz);

    <T> Optional<T> findOne(Specification<E> spec, Class<T> clazz);

    E findOneOrThrow(UUID id);

    E findOneOrThrow(Specification<E> spec);

    <T> T findOneOrThrow(UUID id, Class<T> clazz);

    <T> T findOneOrThrow(Specification<E> spec, Class<T> clazz);

}
