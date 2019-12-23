package org.spring.match.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {
	private static ApplicationContext appCtx;
	/**
	 * 将ApplicationContext对象inject到当前类中作为一个静态成员变量。
	 * @param applicationContext ApplicationContext 对象.
	 * @throws BeansException
	 * @author A_Dragon
	 */
	@Override
	public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
		appCtx = applicationContext;
	}

	/**
	 * 获取ApplicationContext
	 * @return
	 * @author A_Dragon
	 */
	public static ApplicationContext getApplicationContext(){
		return appCtx;
	}

	/**
	 * 通过beanName得到一个BEAN
	 * @param beanName bean的名字
	 * @return 返回一个bean对象
	 * @author A_Dragon
	 */
	public static Object getBean( String beanName ) {
		return getApplicationContext().getBean( beanName );
	}

	/**
	 * 通过Class得到一个BEAN
	 * @param clazz bean的名字
	 * @return 返回一个bean对象
	 * @author A_Dragon
	 */
	public static <T> T getBean(Class<T> clazz){
		return getApplicationContext().getBean(clazz);
	}
}
