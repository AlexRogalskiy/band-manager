package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class HitParade {

    @Id
    @SequenceGenerator(name = "hitParadeSequence", sequenceName = "hit_parade_sequence", allocationSize = 1)
    @GeneratedValue(generator = "hitParadeSequence")
    private Long id;

    @OneToOne
    @JoinColumn(name = "band_id")
    private Band band;

    @SequenceGenerator(name = "hitParadePositionSequence", sequenceName = "hit_parade_position_sequence", allocationSize = 1)
    @GeneratedValue(generator = "hitParadePositionSequence")
    private Long position;
}
