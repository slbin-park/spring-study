package com.example.scheduler.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class PrintJob implements Job {

  @Override
  public void execute(JobExecutionContext context) {
    System.out.println("스케줄링 실행했습니다.");
  }
}
