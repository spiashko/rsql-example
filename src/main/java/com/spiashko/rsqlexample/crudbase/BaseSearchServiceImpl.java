package com.spiashko.rsqlexample.crudbase;


import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import com.spiashko.rsqlexample.crudbase.exception.EntityNotFoundException;
import com.spiashko.rsqlexample.crudbase.repository.BaseJournalRepository;
import net.jodah.typetools.TypeResolver;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class BaseSearchServiceImpl<
        E extends BaseJournalEntity,
        R extends BaseJournalRepository<E>,
        RCR extends RetrieveContextResolver<E>>
        implements BaseSearchService<E> {

    private final RCR resolver;
    private final R repository;
    private final Class<E> persistentClass;

    protected BaseSearchServiceImpl(RCR resolver, R repository) {
        this.resolver = resolver;
        this.repository = repository;

        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(BaseJournalRepository.class, repository.getClass());
        this.persistentClass = (Class<E>) typeArguments[0];
    }

    @Transactional(readOnly = true)
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<E> findAll(Specification<E> spec) {
        return repository.findAll(spec);
    }

    @Transactional(readOnly = true)
    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        RetrieveContext<E, T> retrieveContext = resolver.resolve(clazz);
        Iterable<E> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(e -> retrieveContext.getMapper().apply(e))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public <T> List<T> findAll(Class<T> clazz, Specification<E> spec) {
        RetrieveContext<E, T> retrieveContext = resolver.resolve(clazz);
        Iterable<E> iterable = repository.findAll(spec);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(e -> retrieveContext.getMapper().apply(e))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<E> findOne(UUID id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<E> findOne(Specification<E> spec) {
        return repository.findOne(spec);
    }

    @Transactional(readOnly = true)
    @Override
    public <T> Optional<T> findOne(UUID id, Class<T> clazz) {
        RetrieveContext<E, T> retrieveContext = resolver.resolve(clazz);
        Optional<E> entity = repository.findById(id);
        return entity.map(e -> retrieveContext.getMapper().apply(e));
    }

    @Transactional(readOnly = true)
    @Override
    public <T> Optional<T> findOne(Specification<E> spec, Class<T> clazz) {
        RetrieveContext<E, T> retrieveContext = resolver.resolve(clazz);
        Optional<E> entity = repository.findOne(spec);
        return entity.map(e -> retrieveContext.getMapper().apply(e));
    }

    @Transactional(readOnly = true)
    @Override
    public E findOneOrThrow(UUID id) {
        Optional<E> result = findOne(id);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    @Transactional(readOnly = true)
    @Override
    public E findOneOrThrow(Specification<E> spec) {
        Optional<E> result = findOne(spec);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with spec %s exists!", persistentClass.getSimpleName(), spec));
        }
        return result.get();
    }

    @Transactional(readOnly = true)
    @Override
    public <T> T findOneOrThrow(UUID id, Class<T> clazz) {
        Optional<T> result = findOne(id, clazz);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with id %s exists!", persistentClass.getSimpleName(), id));
        }
        return result.get();
    }

    @Transactional(readOnly = true)
    @Override
    public <T> T findOneOrThrow(Specification<E> spec, Class<T> clazz) {
        Optional<T> result = findOne(spec, clazz);
        if (result.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("No %s entity with spec %s exists!", persistentClass.getSimpleName(), spec));
        }
        return result.get();
    }


    protected R getRepository() {
        return repository;
    }
}
