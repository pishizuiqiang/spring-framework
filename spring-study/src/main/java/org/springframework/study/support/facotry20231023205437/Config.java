package org.springframework.study.support.facotry20231023205437;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.alias.User;

/**
 * todo
 *
 * @author pishi
 * @date 2023年10月06日 15:24
 */
@Configuration
public class Config {


	@Bean({"u", "user", "userTest"})
	public org.springframework.core.alias.User user() {
		final org.springframework.core.alias.User user = new User();
		user.setName("pishi");
		return user;
	}

}
