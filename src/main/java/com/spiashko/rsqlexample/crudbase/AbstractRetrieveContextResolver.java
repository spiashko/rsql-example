package com.spiashko.rsqlexample.crudbase;

import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import com.spiashko.rsqlexample.crudbase.exception.RequestedClassNotSupportedException;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractRetrieveContextResolver<E extends BaseJournalEntity>
        implements RetrieveContextResolver<E>, InitializingBean {

    private final Map<Class<?>, RetrieveContext<E, ?>> mapping = new HashMap<>();

    protected <T> void putInMapping(
            Class<T> clazz,
            Function<E, T> mapper) {
        if (mapping.containsKey(clazz)) {
            throw new IllegalArgumentException("duplicate mapping");
        }
        mapping.put(clazz, new RetrieveContext<>(mapper));
    }

    @Override
    public void afterPropertiesSet() {
        if (mapping.isEmpty()) {
            throw new IllegalArgumentException("mapping must be set");
        }
    }

    @Override
    public <T> RetrieveContext<E, T> resolve(Class<T> clazz) throws RequestedClassNotSupportedException {

        RetrieveContext<E, ?> retrieveContext = mapping.get(clazz);

        if (retrieveContext == null) {
            throw new RequestedClassNotSupportedException(clazz);
        }

        return (RetrieveContext<E, T>) retrieveContext;
    }

}
