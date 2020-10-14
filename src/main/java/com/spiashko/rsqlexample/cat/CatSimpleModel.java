package com.spiashko.rsqlexample.cat;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CatSimpleModel {

    private UUID id;
    private String name;
    private LocalDate dob;
    private UUID ownerId;

}
