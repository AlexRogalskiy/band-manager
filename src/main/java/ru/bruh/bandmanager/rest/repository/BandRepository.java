package ru.bruh.bandmanager.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bruh.bandmanager.model.Band;

import java.util.Optional;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    Optional<Band> findByName(String name);
}
