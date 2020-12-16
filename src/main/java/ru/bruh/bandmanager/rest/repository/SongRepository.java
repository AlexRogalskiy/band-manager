package ru.bruh.bandmanager.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bruh.bandmanager.model.Band;
import ru.bruh.bandmanager.model.Song;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<Song> findByName(String name);

    Set<Song> findAllByBand(Band band);
}
