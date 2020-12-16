package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class Song {

    @Id
    @SequenceGenerator(name = "songSequence", sequenceName = "song_sequence", allocationSize = 1)
    @GeneratedValue(generator = "songSequence")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

    @ManyToOne
    @JoinColumn(name = "compositor_id")
    private Member compositor;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    private LocalDateTime creationDate;
}
