package com.example.scheduler.schedule.job;

import com.example.scheduler.member.repository.MemberRepository;
import com.example.scheduler.member.repository.entity.Member;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

@AllArgsConstructor
public class PrintJob implements Job {

  private MemberRepository memberRepository;

  @Override
  @Transactional
  public void execute(JobExecutionContext context) {
    JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
    String title = jobDataMap.getString("title");
    System.out.println(title);
    System.out.println("스케줄링 실행했습니다.");
    Member member = new Member();
    member.setEmail(title);
    member.setPassword("1234");
  }
}
