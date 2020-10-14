package com.spiashko.rsqlexample.cat.impl;

import com.spiashko.rsqlexample.cat.Cat;
import com.spiashko.rsqlexample.cat.CatCreationModel;
import com.spiashko.rsqlexample.crudbase.mapperconfig.CreationMapperMappingConfig;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.persistence.EntityManager;

@Mapper(config = CreationMapperMappingConfig.class)
interface CatCreationMapper {

    @Mapping(target = "owner", source = "ownerId")
    Cat map(CatCreationModel creationModel, @Context EntityManager entityManager);

}
