package com.spiashko.rsqlexample.cat.impl;

import com.spiashko.rsqlexample.cat.Cat;
import com.spiashko.rsqlexample.cat.CatCreationModel;
import com.spiashko.rsqlexample.cat.CatCreationService;
import com.spiashko.rsqlexample.cat.CatSimpleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
class CatCreationServiceImpl implements CatCreationService {

    private final CatRepository repository;
    private final CatCreationMapper creationMapper;
    private final CatSearchMapper searchMapper;
    private final EntityManager entityManager;

    @Override
    public CatSimpleModel create(CatCreationModel creationModel) {
        Cat entity = creationMapper.map(creationModel, entityManager);
        repository.save(entity);
        return searchMapper.mapToSimpleModel(entity);
    }

}
