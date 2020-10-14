package com.spiashko.rsqlexample.crudbase.mapperconfig;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SearchMapperMappingConfig {
}