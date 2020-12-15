package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class Band {

    @Id
    @SequenceGenerator(name = "bandSequence", sequenceName = "band_sequence", allocationSize = 1)
    @GeneratedValue(generator = "bandSequence")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private LocalDateTime formationYear;

    @OneToOne
    @JoinColumn(referencedColumnName = "band_id", name = "id")
    private HitParade hitParade;
}
