package com.spiashko.rsqlexample.person;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PersonSimpleModel {

    private UUID id;
    private String name;
    private List<CatSimpleModel> kittens;

    @Getter
    @Setter
    public static class CatSimpleModel {

        private UUID id;
        private String name;
        private LocalDate dob;

    }

}
