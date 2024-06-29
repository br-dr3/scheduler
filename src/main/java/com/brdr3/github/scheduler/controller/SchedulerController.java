package com.brdr3.github.scheduler.controller;

import com.brdr3.github.scheduler.enuns.Schedule;
import com.brdr3.github.scheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedule/{schedule}/{date}")
    public ResponseEntity<Boolean> shouldExecute(@PathVariable final Schedule schedule, @PathVariable final LocalDate date) {
        return ResponseEntity.ok().body(scheduleService.shouldExecute(date, schedule));
    }
}
