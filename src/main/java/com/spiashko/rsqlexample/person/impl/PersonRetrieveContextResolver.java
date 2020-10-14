package com.spiashko.rsqlexample.person.impl;

import com.spiashko.rsqlexample.crudbase.AbstractRetrieveContextResolver;
import com.spiashko.rsqlexample.person.Person;
import com.spiashko.rsqlexample.person.PersonSimpleModel;
import org.springframework.stereotype.Component;

@Component
class PersonRetrieveContextResolver extends AbstractRetrieveContextResolver<Person> {

    PersonRetrieveContextResolver(PersonSearchMapper mapper) {
        putInMapping(PersonSimpleModel.class, mapper::mapToSimpleModel);
    }

}
