package com.spiashko.rsqlexample.person.impl;

import com.spiashko.rsqlexample.crudbase.mapperconfig.CreationMapperMappingConfig;
import com.spiashko.rsqlexample.person.Person;
import com.spiashko.rsqlexample.person.PersonCreationModel;
import org.mapstruct.Mapper;

@Mapper(config = CreationMapperMappingConfig.class)
interface PersonCreationMapper {

    Person map(PersonCreationModel creationModel);

}
