package com.spiashko.rsqlexample.cat;


import com.spiashko.rsqlexample.crudbase.entity.BaseJournalEntity;
import com.spiashko.rsqlexample.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cat")
public class Cat extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "dob")
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_owner")
    private Person owner;

}
