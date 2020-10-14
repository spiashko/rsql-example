package com.spiashko.rsqlexample.person.impl;

import com.spiashko.rsqlexample.crudbase.mapperconfig.SearchMapperMappingConfig;
import com.spiashko.rsqlexample.person.Person;
import com.spiashko.rsqlexample.person.PersonSimpleModel;
import org.mapstruct.Mapper;

@Mapper(config = SearchMapperMappingConfig.class)
interface PersonSearchMapper {

    PersonSimpleModel mapToSimpleModel(Person entity);

}
