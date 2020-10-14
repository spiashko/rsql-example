package com.spiashko.rsqlexample.person.impl;

import com.spiashko.rsqlexample.crudbase.BaseSearchServiceImpl;
import com.spiashko.rsqlexample.person.Person;
import com.spiashko.rsqlexample.person.PersonSearchService;
import org.springframework.stereotype.Service;

@Service
class PersonSearchServiceImpl
        extends BaseSearchServiceImpl<Person, PersonRepository, PersonRetrieveContextResolver>
        implements PersonSearchService {

    public PersonSearchServiceImpl(
            PersonRepository repository,
            PersonRetrieveContextResolver resolver) {
        super(resolver, repository);
    }
}
