package com.brdr3.github.scheduler.service;

import com.brdr3.github.scheduler.entity.HolidayEntity;
import com.brdr3.github.scheduler.repository.HolidayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HolidayService {
    private final HolidayRepository holidayRepository;

    public Boolean isHoliday(final LocalDate date) {
        Optional<HolidayEntity> holiday = holidayRepository.getHoliday(date);
        return holiday.map(HolidayEntity::getDataFeriado).isPresent();
    }

    public Boolean isPostHoliday(final LocalDate date) {
        return isHoliday(date.minusDays(1));
    }
}
