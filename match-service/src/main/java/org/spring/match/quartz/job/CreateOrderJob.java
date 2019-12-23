package org.spring.match.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.match.service.IOrderService;
import org.spring.match.util.ApplicationContextHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 创建订单job
 * @author A_Dragon
 * @since 2019-12-12
 */
@Component
@EnableScheduling
@DisallowConcurrentExecution  //代表设置该任务为串行执行
public class CreateOrderJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateOrderJob.class);

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
	 *  创建订单任务
	 * @throws JobExecutionException
	 */
	public void task(){
		IOrderService orderMainService = ApplicationContextHelper.getBean(IOrderService.class);
		orderMainService.createOrder();
		LOGGER.info("orderMainService：		"+orderMainService);
	}
}

