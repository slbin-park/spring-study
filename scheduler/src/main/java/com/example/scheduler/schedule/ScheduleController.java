package com.example.scheduler.schedule;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

  private final ScheduleService scheduleService;

  @ResponseBody
  @PostMapping
  public String setSchedule(@RequestBody CreateScheduleRequest createScheduleRequest)
      throws Exception {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime oneMinuteLater = now.plusSeconds(5);
    Date date = Date.from(oneMinuteLater.atZone(ZoneId.systemDefault()).toInstant());

    scheduleService.schedulerOneTimeJob(date, createScheduleRequest);
    return "SUCCESS";
  }

  @GetMapping
  public String printSchedule() throws Exception {
    scheduleService.printAllJobs();
    return "SUCCESS";
  }

}
