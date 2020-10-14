package com.spiashko.rsqlexample.person.impl;

import com.spiashko.rsqlexample.person.Person;
import com.spiashko.rsqlexample.person.PersonCreationModel;
import com.spiashko.rsqlexample.person.PersonCreationService;
import com.spiashko.rsqlexample.person.PersonSimpleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class PersonCreationServiceImpl implements PersonCreationService {

    private final PersonRepository repository;
    private final PersonCreationMapper creationMapper;
    private final PersonSearchMapper searchMapper;

    @Override
    public PersonSimpleModel create(PersonCreationModel creationModel) {
        Person entity = creationMapper.map(creationModel);
        repository.save(entity);
        return searchMapper.mapToSimpleModel(entity);
    }

}
