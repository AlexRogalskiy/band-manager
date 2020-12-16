package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class Member {

    @Id
    @SequenceGenerator(name = "memberSequence", sequenceName = "member_sequence", allocationSize = 1)
    @GeneratedValue(generator = "memberSequence")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private MemberRole memberRole;
}
