package com.spiashko.rsqlexample.person;


import com.spiashko.rsqlexample.cat.Cat;
import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Cat> kittens;

}
