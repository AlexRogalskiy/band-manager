package ru.bruh.bandmanager.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class MemberRole {

    @Id
    @SequenceGenerator(name = "memberRoleSequence", sequenceName = "member_role_sequence", allocationSize = 1)
    @GeneratedValue(generator = "memberRoleSequence")
    private Long id;

    private String name;
}
