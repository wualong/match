package org.spring.match.dto;

import lombok.Data;

@Data
public class SftpDTO {
	// 时
	String hour;
	// 分
	String minute;
	// 每周几
	Integer week;
	// 每月几号
	String day;
	/* 执行时间 0每天,1每周,2每月 */
	Integer execType;
	String id;
}
