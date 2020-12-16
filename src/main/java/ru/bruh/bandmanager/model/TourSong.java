package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class TourSong {

    @Id
    @SequenceGenerator(name = "tourSequence", sequenceName = "tour_sequence", allocationSize = 1)
    @GeneratedValue(generator = "tourSequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
