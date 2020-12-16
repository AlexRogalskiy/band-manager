package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class Tour {

    @Id
    @SequenceGenerator(name = "tourSequence", sequenceName = "tour_sequence", allocationSize = 1)
    @GeneratedValue(generator = "tourSequence")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private BigDecimal ticketPrice;
}
