package ru.bruh.bandmanager.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bruh.bandmanager.model.Tour;
import ru.bruh.bandmanager.model.TourSong;

import java.util.List;

@Repository
public interface TourSongRepository extends JpaRepository<TourSong, Long> {

    List<TourSong> findAllByTour(Tour tour);
}
