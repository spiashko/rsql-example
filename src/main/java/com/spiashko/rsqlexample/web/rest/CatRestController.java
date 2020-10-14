package com.spiashko.rsqlexample.web.rest;

import com.spiashko.rsqlexample.cat.*;
import com.spiashko.rsqlexample.rsql.AndPathVarEq;
import com.spiashko.rsqlexample.rsql.RsqlSpec;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CatRestController {

    private final CatCreationService creationService;
    private final CatSearchService searchService;

    @PostMapping("/cats")
    public CatSimpleModel create(@RequestBody CatCreationModel createRequest) {
        CatSimpleModel result = creationService.create(createRequest);
        return result;
    }

    @GetMapping("/cats")
    public List<CatSimpleModel> findAll(
            @RsqlSpec Specification<Cat> spec
    ) {
        List<CatSimpleModel> result = searchService.findAll(CatSimpleModel.class, spec);
        return result;
    }

    @Parameter(in = ParameterIn.PATH
            , name = "ownerId"
            , content = @Content(schema = @Schema(type = "integer")))
    @RequestMapping(path = "/owner/{ownerId}/cats", method = RequestMethod.GET)
    public List<CatSimpleModel> findAllByOwner(
            @Parameter(hidden = true)
            @RsqlSpec(
                    extensionFromPath = @AndPathVarEq(pathVar = "ownerId", attributePath = "owner.id")
            ) Specification<Cat> spec
    ) {
        List<CatSimpleModel> result = searchService.findAll(CatSimpleModel.class, spec);
        return result;
    }

}
