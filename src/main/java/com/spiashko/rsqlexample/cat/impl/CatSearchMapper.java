package com.spiashko.rsqlexample.cat.impl;

import com.spiashko.rsqlexample.cat.Cat;
import com.spiashko.rsqlexample.cat.CatSimpleModel;
import com.spiashko.rsqlexample.crudbase.mapperconfig.SearchMapperMappingConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SearchMapperMappingConfig.class)
interface CatSearchMapper {

    @Mapping(target = "ownerId", source = "owner.id")
    CatSimpleModel mapToSimpleModel(Cat entity);

}
