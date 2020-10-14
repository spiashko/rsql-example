package com.spiashko.rsqlexample.crudbase;


import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import com.spiashko.rsqlexample.crudbase.exception.RequestedClassNotSupportedException;

public interface RetrieveContextResolver<E extends BaseJournalEntity> {

    <T> RetrieveContext<E, T> resolve(Class<T> clazz) throws RequestedClassNotSupportedException;

}
