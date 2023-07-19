package com.example.scheduler.schedule.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

public class PrintJob implements Job {

  @Override
  public void execute(JobExecutionContext context) {
    JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
    String title = jobDataMap.getString("title");
    System.out.println(title);
    System.out.println("스케줄링 실행했습니다.");
  }
}
