package com.spiashko.rsqlexample.crudbase;

import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
@Getter
public class RetrieveContext<E extends BaseJournalEntity, T> {

    private final Function<E, T> mapper;

}
