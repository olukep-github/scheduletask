package com.bjca.scheduletask.Job;

import org.quartz.*;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class MyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();

        System.out.println("TaskName:" + jobDetail.getKey().getName());
        System.out.println("GroupName:" + jobDetail.getKey().getGroup());
        System.out.println("ClassName:" + jobDetail.getJobClass().getName());
        System.out.println("ExecuteTime:" + context.getFireTime());
        System.out.println("NextTime:" + context.getNextFireTime());
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        Integer count= (Integer) jobDataMap.get("count");
        System.out.println("Count:" + count);
        jobDataMap.put("count", ++count);


    }
}
