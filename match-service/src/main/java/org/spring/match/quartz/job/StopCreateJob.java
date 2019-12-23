package org.spring.match.quartz.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.match.quartz.QuartzManager;
import org.spring.match.service.IOrderService;
import org.spring.match.util.ApplicationContextHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 停止订单job
 * @author A_Dragon
 * @since 2019-12-12
 */
@Component
@EnableScheduling
//@DisallowConcurrentExecution
public class StopCreateJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(StopCreateJob.class);

	/**
	 * 可执行订单加入的任务（保留）
	 * @param context
	 * @throws JobExecutionException
	 */
	@Override
	public void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();//获取传入的参数数据
	}

	/**
	 *  判断数据量进行是否移除订单任务
	 * @throws JobExecutionException
	 */
	public void task(){
//		JobDetailImpl firstJobDetail = (JobDetailImpl)ApplicationContextHelper.getBean("firstJobDetail");
		QuartzManager quartzManager = ApplicationContextHelper.getBean(QuartzManager.class);
		IOrderService orderMainService = ApplicationContextHelper.getBean(IOrderService.class);
		boolean b = orderMainService.stopCreateOrder();
		if(b){
			quartzManager.removeJob("firstJobDetail","DEFAULT","firstTrigger","DEFAULT");
		}
		LOGGER.info("结果：		"+b);
	}
}

