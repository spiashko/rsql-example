package com.spiashko.rsqlexample.cat.impl;

import com.spiashko.rsqlexample.cat.Cat;
import com.spiashko.rsqlexample.cat.CatSearchService;
import com.spiashko.rsqlexample.crudbase.BaseSearchServiceImpl;
import org.springframework.stereotype.Service;

@Service
class CatSearchServiceImpl
        extends BaseSearchServiceImpl<Cat, CatRepository, CatRetrieveContextResolver>
        implements CatSearchService {

    public CatSearchServiceImpl(
            CatRepository repository,
            CatRetrieveContextResolver resolver) {
        super(resolver, repository);
    }
}
