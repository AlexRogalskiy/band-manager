package ru.bruh.bandmanager.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Tour;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    Optional<Tour> findByName(String name);

    List<Tour> findAllByBand(Band band);
}
