package org.springframework.study.support;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author pishi
 * @date 2023年09月09日 18:03
 */
public class BeanNameGeneratorTest {

	public static void main(String[] args) {

		final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		final Object bean = classPathXmlApplicationContext.getBean("org.springframework.study.support.Dog");

		System.out.println("bean = " + bean);
	}

}
