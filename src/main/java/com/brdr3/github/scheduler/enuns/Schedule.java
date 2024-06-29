package com.brdr3.github.scheduler.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.Map;

import static com.brdr3.github.scheduler.enuns.ExecutionConfiguration.*;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

@Getter
@AllArgsConstructor
public enum Schedule {
    ALL_DAYS(Map.ofEntries(
            Map.entry(MONDAY, ALWAYS),
            Map.entry(TUESDAY, ALWAYS),
            Map.entry(WEDNESDAY, ALWAYS),
            Map.entry(THURSDAY, ALWAYS),
            Map.entry(FRIDAY, ALWAYS),
            Map.entry(SATURDAY, ALWAYS),
            Map.entry(SUNDAY, ALWAYS))),

    WORKING_DAYS(Map.ofEntries(
            Map.entry(MONDAY, NOT_HOLIDAYS),
            Map.entry(TUESDAY, NOT_HOLIDAYS),
            Map.entry(WEDNESDAY, NOT_HOLIDAYS),
            Map.entry(THURSDAY, NOT_HOLIDAYS),
            Map.entry(FRIDAY, NOT_HOLIDAYS),
            Map.entry(SATURDAY, NEVER),
            Map.entry(SUNDAY, NEVER))),

    RANDOM_CALENDAR(Map.ofEntries(
            Map.entry(MONDAY, NOT_HOLIDAYS),
            Map.entry(TUESDAY, NOT_HOLIDAY_AND_NOT_POS_HOLIDAY),
            Map.entry(WEDNESDAY, NOT_HOLIDAYS),
            Map.entry(THURSDAY, NOT_HOLIDAYS),
            Map.entry(FRIDAY, NOT_HOLIDAYS),
            Map.entry(SATURDAY, NOT_HOLIDAYS),
            Map.entry(SUNDAY, NOT_HOLIDAYS)));

    private final Map<DayOfWeek, ExecutionConfiguration> configuration;
}
