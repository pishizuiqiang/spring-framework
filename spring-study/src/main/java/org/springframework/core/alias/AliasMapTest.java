package org.springframework.core.alias;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试 AliasMap 的别名链
 *
 * @author pishi
 * @date 2023年10月05日 14:44
 */

public class AliasMapTest {

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		final String[] users = context.getAliases("user");
		for (String user : users) {
			System.out.println("user = " + user);
		}
		context.getBean("user");


	}


}
