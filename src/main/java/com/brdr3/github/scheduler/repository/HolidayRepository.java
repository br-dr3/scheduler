package com.brdr3.github.scheduler.repository;

import com.brdr3.github.scheduler.entity.HolidayEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public class HolidayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<HolidayEntity> getHoliday(final LocalDate date) {
        try {
            final var holiday = entityManager.createQuery("SELECT h FROM HolidayEntity h WHERE h.dataFeriado = :dataFeriado", HolidayEntity.class)
                    .setParameter("dataFeriado", date)
                    .getSingleResult();

            return Optional.ofNullable(holiday);
        } catch (Exception e) {
            return Optional.empty();
        }

    }
}
