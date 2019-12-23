
package org.spring.match.quartz;

import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *  QuartzManager 工具类
 *  @author A_Dragon
 *  @since 2019-11-26
 */
@Service
public class QuartzManager {

	private Scheduler scheduler;

	public QuartzManager(Scheduler scheduler){
		this.scheduler = scheduler;
	}

	/**
	 * 添加一个定时任务
	 *
	 * @param jobName           任务名
	 * @param jobGroupName      任务组名
	 * @param triggerName       触发器名
	 * @param triggerGroupName  触发器组名
	 * @param jobClass          任务
	 * @param cron              时间设置，参考quartz说明文档
	 * @param params            设置参数(在具体的job类里去获取参数例子：JobDataMap data = jobExecutionContext.getJobDetail().getJobDataMap();//获取传入的参数数据 )
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron, Map<String, Object> params) {
		try {
			// 任务名，任务组，任务执行类
			JobDetail job = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
			// 任务参数
			job.getJobDataMap().putAll(params);

			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// 调度容器设置JobDetail和Trigger
			scheduler.scheduleJob(job, trigger);

			// 启动
			if (!scheduler.isShutdown()) {
				scheduler.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改一个任务的触发时间
	 *
	 * @param triggerName       触发器名
	 * @param triggerGroupName  触发器组名
	 * @param cron              时间设置，参考quartz说明文档
	 */
	public void modifyJobTime(String triggerName, String triggerGroupName, String cron) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}

			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				scheduler.rescheduleJob(triggerKey, trigger);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 移除一个任务
	 *
	 * @param jobName           任务名
	 * @param jobGroupName      任务组名
	 * @param triggerName       触发器名
	 * @param triggerGroupName  触发器组名
	 */
	public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		try {

			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

			// 停止触发器
			scheduler.pauseTrigger(triggerKey);
			// 移除触发器
			scheduler.unscheduleJob(triggerKey);
			// 删除任务
			scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取任务是否存在
	 *
	 * STATE_BLOCKED 4 阻塞
	 * STATE_COMPLETE 2 完成
	 * STATE_ERROR 3 错误
	 * STATE_NONE -1 不存在
	 * STATE_NORMAL 0 正常
	 * STATE_PAUSED 1 暂停
	 *
	 */
	public  Boolean notExists(String triggerName, String triggerGroupName) {
		try {
			return scheduler.getTriggerState(TriggerKey.triggerKey(triggerName, triggerGroupName)) == Trigger.TriggerState.NONE;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取任务状态
	 *
	 * STATE_BLOCKED 4 阻塞
	 * STATE_COMPLETE 2 完成
	 * STATE_ERROR 3 错误
	 * STATE_NONE -1 不存在
	 * STATE_NORMAL 0 正常
	 * STATE_PAUSED 1 暂停
	 *
	 */
	public Trigger.TriggerState getStatus(String triggerName, String triggerGroupName) {
		try {
			return scheduler.getTriggerState(TriggerKey.triggerKey(triggerName, triggerGroupName));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
     * 暂停所有任务
     */
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    /**
     * 暂停某个任务
     */
    public void pauseJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复所有任务
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
     * 恢复某个任务
     */
    public void resumeJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除某个任务
     */
    public void deleteJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.deleteJob(jobKey);
    }

    /**
     * 获取Job信息
     */
    public String getJobInfo(String name, String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                scheduler.getTriggerState(triggerKey).name());
    }



}
