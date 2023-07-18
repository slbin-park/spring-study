package com.example.scheduler.schedule;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ScheduleServiceTest {

  @Autowired
  private Scheduler scheduler;

  @Autowired
  private ScheduleService scheduleService;

  @BeforeEach
  public void clearScheduler() throws SchedulerException {
    scheduler.clear();
  }

  @Test
  @DisplayName("스케줄러를 하나 등록하고 등록된 스케줄러는 1개만 존재한다.")
  public void scheduleOneTimeJob() throws SchedulerException {
    // Given
    Date date = Date.from(Instant.now().plusMillis(60000)); // 1분뒤

    // When
    scheduleService.schedulerOneTimeJob(date);

    // Then
    // job의 개수를 구한다
    int jobCount = 0;
    for (String groupName : scheduler.getJobGroupNames()) {
      for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
        jobCount++;
      }
    }

    assertEquals(1, jobCount);
  }

  @Test
  @DisplayName("스케줄링 등록후 스케줄러들 정상 출력")
  public void printAllJobs() throws SchedulerException {
    // Given
    Date date = Date.from(Instant.now().plusMillis(60000)); // 1분뒤
    scheduleService.schedulerOneTimeJob(date);

    // When
    // It should print all jobs without throwing an exception
    assertDoesNotThrow(() -> scheduleService.printAllJobs());
  }

}