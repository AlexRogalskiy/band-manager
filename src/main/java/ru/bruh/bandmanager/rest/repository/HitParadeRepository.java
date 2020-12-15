package ru.bruh.bandmanager.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.bruh.bandmanager.model.HitParade;

import java.util.Optional;

@Repository
public interface HitParadeRepository extends JpaRepository<HitParade, Long> {

    @Query(value = "SELECT COALESCE(MAX(position), 0) + 1 AS position FROM hit_parade", nativeQuery = true)
    Long getLastPosition();

    Optional<HitParade> findByPosition(Long position);
}
