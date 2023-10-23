package org.springframework.core.alias;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo
 *
 * @author pishi
 * @date 2023年10月06日 15:24
 */
@Configuration
public class Config {


	@Bean({"u", "user", "userTest"})
	public User user() {
		final User user = new User();
		user.setName("pishi");
		return user;
	}

}
