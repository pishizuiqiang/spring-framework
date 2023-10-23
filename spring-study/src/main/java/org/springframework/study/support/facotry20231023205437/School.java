package org.springframework.study.support.facotry20231023205437;


import org.springframework.beans.factory.annotation.Autowired;

public class School {


	@Autowired
	private User user;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "School{" +
				"user=" + user +
				'}';
	}
}
