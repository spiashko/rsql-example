package com.spiashko.rsqlexample.web.rest;

import com.spiashko.rsqlexample.person.*;
import com.spiashko.rsqlexample.rsql.RsqlSpec;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonRestController {

    private final PersonCreationService creationService;
    private final PersonSearchService searchService;

    @PostMapping
    public PersonSimpleModel create(@RequestBody PersonCreationModel createRequest) {
        PersonSimpleModel result = creationService.create(createRequest);
        return result;
    }

    @GetMapping
    public List<PersonSimpleModel> findAll(
            @Parameter(hidden = true)
            @RsqlSpec Specification<Person> spec
    ) {
        List<PersonSimpleModel> result = searchService.findAll(PersonSimpleModel.class, spec);
        return result;
    }

}
