package org.springframework.study.support.facotry20231023205437;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.alias.Config;

/**
 * todo
 *
 * @author pishi
 * @date 2023年10月23日 21:03
 */
public class AutowireCapableBeanFactoryTest {


	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		final AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();

		final School school = new School();

		// 1. 使用AutowireCapableBeanFactory去装配不受Spring管理的bean
		autowireCapableBeanFactory.autowireBeanProperties(school, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
		// 2. 进行初始化
		autowireCapableBeanFactory.initializeBean(school, "school" + AutowireCapableBeanFactory.ORIGINAL_INSTANCE_SUFFIX);

		System.out.println("school = " + school);


	}

}
