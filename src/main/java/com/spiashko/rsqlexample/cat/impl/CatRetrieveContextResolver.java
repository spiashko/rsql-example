package com.spiashko.rsqlexample.cat.impl;

import com.spiashko.rsqlexample.cat.Cat;
import com.spiashko.rsqlexample.cat.CatSimpleModel;
import com.spiashko.rsqlexample.crudbase.AbstractRetrieveContextResolver;
import org.springframework.stereotype.Component;

@Component
class CatRetrieveContextResolver extends AbstractRetrieveContextResolver<Cat> {

    CatRetrieveContextResolver(CatSearchMapper mapper) {
        putInMapping(CatSimpleModel.class, mapper::mapToSimpleModel);
    }

}
