package org.spring.match.util;


import org.spring.match.dto.SftpDTO;

/**
 *  获取cron表达式的工具类
 * @Author A_Dragon
 * @Date 2019/11/26
 */
public class CronUtil {

	public static final Integer EVERY_DAY = 1;

	public static final Integer EVERY_WEEK = 2;

	public static final Integer EVERY_YEAR = 3;


	/**
	 *  根据配置生成cron表达式
	 */
	public static String getCron(SftpDTO dto) {
		// 时
		String hour = dto.getHour();
		// 分
		String minute = dto.getMinute();
		// 每周几
		Integer week = dto.getWeek();
		// 每月几号
		String day = dto.getDay();

		/* 执行时间 0每天,1每周,2每月 */
		Integer execType = dto.getExecType();

		String cron;
		switch (execType) {
			case 0:
				cron = String.format("* * %s * * ? *" , hour);
				break;
			case 1:
				week = (week + 1) % 7;
				cron = String.format("* %s %s ? * %s *", minute, hour, week == 0 ? 7: week);
				break;
			case 2:
				cron = String.format("* %s %s %s * ? *", minute, hour, day);
				break;
			default:
				cron = "0 0 0 * * ? *";
				break;
		}
		return cron;
	}

}
