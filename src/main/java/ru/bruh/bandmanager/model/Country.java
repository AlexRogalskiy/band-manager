package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class Country {

    @Id
    @SequenceGenerator(name = "countrySequence", sequenceName = "country_sequence", allocationSize = 1)
    @GeneratedValue(generator = "countrySequence")
    private Long id;

    private String name;
}
