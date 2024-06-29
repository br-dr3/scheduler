package com.brdr3.github.scheduler.controller;

import com.brdr3.github.scheduler.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class HolidayController {

    private final HolidayService holidayService;

    @GetMapping("/holidays/{date}")
    public ResponseEntity<Boolean> isHoliday(@PathVariable final LocalDate date) {
        return ResponseEntity.ok().body(holidayService.isHoliday(date));
    }

    @GetMapping("/postHolidays/{date}")
    public ResponseEntity<Boolean> isPostHoliday(@PathVariable final LocalDate date) {
        return ResponseEntity.ok().body(holidayService.isPostHoliday(date));
    }
}
