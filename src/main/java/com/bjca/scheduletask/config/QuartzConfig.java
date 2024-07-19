package com.bjca.scheduletask.config;

import com.bjca.scheduletask.Job.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob1","group1")
                .storeDurably()
                .usingJobData("count",1)
                .build();
    }

    @Bean
    public Trigger trigger() {
        String cronExpression = "0/5 * * * * ?";
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .withIdentity("myTrigger1","group1")
                .build();
    }
}
