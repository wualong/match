package org.spring.match.quartz;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.match.dto.SftpDTO;
import org.spring.match.util.CronUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 管理任务
 */
@Service
public class SftpTask {
	// 任务名前缀
	private final String job_prefix = "job_";
	// 任务组前缀
	private final String job_group_prefix = "job_group_";
	// 触发器前缀
	private final String trigger_prefix = "trigger_";
	// 触发组前缀
	private final String trigger_group_prefix = "trigger_group_";

	private QuartzManager quartzManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(SftpTask.class);

	public SftpTask (QuartzManager quartzManager) {
		this.quartzManager = quartzManager;
	}

	/**
	 * 添加定时任务
	 * @param dto 任务相关信息
	 * @param jobClass 任务
	 */
	public void addJob(SftpDTO dto,Class jobClass) {

		String id = dto.getId();
		String cron = CronUtil.getCron(dto);
		Map<String, Object> params = Maps.newHashMap();
		params.put("id", id);
		if(jobClass == null || "".equals(jobClass)){
			LOGGER.info("***********创建任务失败，任务job不能为空********");
			return;
		}
		quartzManager.addJob(
			job_prefix + id,
			job_group_prefix + id,
			trigger_prefix + id,
			trigger_group_prefix + id,
			//Job.class, getCron(new SftpDTO() ), params
			jobClass, cron , params
		);
	}

	/**
	 *  修改定时任务
	 */
	public void modifyJob(SftpDTO dto ,Class jobClass) {
		String id = dto.getId();
		String cron = CronUtil.getCron(dto);
		if (quartzManager.notExists(trigger_prefix + id, trigger_group_prefix + id)){
			// 任务不存在
			LOGGER.info("***********任务不存在，创建新任务********");
			addJob(dto,jobClass);
		} else {
			// 任务存在
			quartzManager.modifyJobTime(
				trigger_prefix + id,
				trigger_group_prefix + id,
				cron
			);
		}
	}

	/**
	 *  移除定时任务
	 */
	public void removeJob(String id) {
		quartzManager.removeJob(
			job_prefix + id,
			job_group_prefix + id,
			trigger_prefix + id,
			trigger_group_prefix + id
		);
	}

	/**
	 * 添加定时任务
	 * @param dto 任务相关信息
	 * @param jobClass 任务
	 * @param params   设置参数(在具体的job类里去获取参数例子：JobDataMap data = jobExecutionContext.getJobDetail().getJobDataMap();//获取传入的参数数据 )
	 */
	public void addJobParams(SftpDTO dto,Class jobClass,Map<String, Object> params) {
		String id = dto.getId();
		String cron = CronUtil.getCron(dto);
		if(jobClass.equals(null) || "".equals(jobClass) || null == jobClass){
			LOGGER.info("***********创建任务失败，任务job不能为空********");
			return;
		}
		quartzManager.addJob(
			job_prefix + id,
			job_group_prefix + id,
			trigger_prefix + id,
			trigger_group_prefix + id,
			//Job.class, getCron(new SftpDTO() ), params
			jobClass, cron , params
		);
	}
}
