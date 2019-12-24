package org.spring.match.config;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.spring.match.quartz.job.CreateOrderJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
//@DisallowConcurrentExecution//代表设置该任务为串行执行
public class QuartzConfig {
	// 配置定时任务1
	@Bean(name = "firstJobDetail")
	public MethodInvokingJobDetailFactoryBean firstJobDetail(CreateOrderJob job) {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		// 是否并发执行
		jobDetail.setConcurrent(true);
		// 为需要执行的实体类对应的对象
		jobDetail.setTargetObject(job);
		// 需要执行的方法
		jobDetail.setTargetMethod("task");
		return jobDetail;
	}

	// 配置触发器1
	@Bean(name = "firstTrigger")
	public CronTriggerFactoryBean firstTrigger(JobDetail firstJobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(firstJobDetail);
		// cron表达式
		trigger.setCronExpression("* * 9-12:30 * * ? *");
		return trigger;
	}

	// 配置Scheduler
	@Bean(name = "scheduler")
	public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger,Trigger secondTrigger) {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		// 延时启动，应用启动2秒后
		bean.setStartupDelay(2);
		// 注册触发器1
		bean.setTriggers(firstTrigger);
		// 注册触发器2
		//bean.setTriggers(secondTrigger);
		return bean;
	}

}
