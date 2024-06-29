package com.brdr3.github.scheduler.service;

import com.brdr3.github.scheduler.enuns.ExecutionConfiguration;
import com.brdr3.github.scheduler.enuns.Schedule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;

import static com.brdr3.github.scheduler.enuns.ExecutionConfiguration.*;
import static java.util.Map.entry;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final HolidayService holidayService;
    private Map<ExecutionConfiguration, Function<LocalDate, Boolean>> HANDLE_CONFIGURATIONS;

    @PostConstruct
    private void postConstruct() {
        HANDLE_CONFIGURATIONS = Map.ofEntries(
                entry(ALWAYS, date -> true),
                entry(NEVER, date -> false),
                entry(NOT_HOLIDAY_AND_NOT_POS_HOLIDAY, date -> !holidayService.isHoliday(date) && !holidayService.isPostHoliday(date)),
                entry(ONLY_HOLIDAYS, holidayService::isHoliday),
                entry(ONLY_POS_HOLIDAYS, holidayService::isPostHoliday),
                entry(NOT_HOLIDAYS, date -> !holidayService.isHoliday(date)),
                entry(NOT_POS_HOLIDAYS, date -> !holidayService.isPostHoliday(date)));
    }

    public Boolean shouldExecute(final LocalDate date, final Schedule schedule) {
        final var configuration = schedule.getConfiguration().get(date.getDayOfWeek());
        return HANDLE_CONFIGURATIONS.get(configuration).apply(date);
    }
}
