package ru.bruh.bandmanager.common.security.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class UserEntity {

    @Id
    @SequenceGenerator(name = "userEntitySequence", sequenceName = "user_entity_sequence", allocationSize = 1)
    @GeneratedValue(generator = "userEntitySequence")
    private Long id;

    private String username;

    private String password;
}
