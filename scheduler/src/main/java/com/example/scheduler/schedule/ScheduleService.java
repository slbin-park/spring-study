package com.example.scheduler.schedule;

import com.example.scheduler.schedule.job.PrintJob;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService {

  private final Scheduler scheduler;

  public void schedulerOneTimeJob(Date date) throws SchedulerException {
    JobDetail jobDetail = builJobDeatil();
    Trigger trigger = buildOneTimeJobTrigger(jobDetail, date);
    scheduler.scheduleJob(jobDetail, trigger);
  }

  private JobDetail builJobDeatil() {
    return JobBuilder.newJob(PrintJob.class)
        .withIdentity(UUID.randomUUID().toString(), "group-name")
        .withDescription("생성된 JOB")
        .build();
  }

  private Trigger buildOneTimeJobTrigger(JobDetail jobDetail, Date date) {
    return TriggerBuilder.newTrigger()
        .forJob(jobDetail)
        .withIdentity(jobDetail.getKey().getName(), "trigger-group")
        .startAt(date)
        .build();
  }

  public void getCurrentlyExecutingJobs() throws SchedulerException {
    List<JobExecutionContext> currentJobs = scheduler.getCurrentlyExecutingJobs();
    for (JobExecutionContext jobContext : currentJobs) {
      JobKey jobKey = jobContext.getJobDetail().getKey();
      System.out.println(
          "Job is running: " + jobKey.getName() + ", Group: " + jobKey.getGroup());
    }
  }

  public void printAllJobs() throws SchedulerException {
    for (String groupName : scheduler.getJobGroupNames()) {
      for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
        System.out.println(
            "Job name: " + jobKey.getName() + ", Group: " + jobKey.getGroup());
      }
    }
  }

}
