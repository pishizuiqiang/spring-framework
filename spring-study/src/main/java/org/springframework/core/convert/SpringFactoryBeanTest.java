package org.springframework.core.convert;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author pishi
 * @description: todo
 * @date 2023年09月01日 14:46
 */
@ComponentScan
@Configuration
 class SpringFactoryBeanTestConfig {
}


public class SpringFactoryBeanTest {
	public static void main(String[] args) {
		final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringFactoryBeanTestConfig.class);

	}
}

class User{
	private String name;

	public User() {
		System.out.println("name = " + name);
	}
}

@Component
class UserFactory implements SmartFactoryBean<User> {

	@Override
	public boolean isEagerInit() {
		return true;
	}

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}