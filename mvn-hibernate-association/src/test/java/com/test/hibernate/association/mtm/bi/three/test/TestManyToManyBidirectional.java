package com.test.hibernate.association.mtm.bi.three.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.mtm.bi.three.Group;
import com.test.hibernate.association.mtm.bi.three.User;
import com.test.hibernate.association.mtm.bi.three.UserGroup;
import com.test.hibernate.association.test.BaseTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestManyToManyBidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		User user = new User("tommy", "ymmot", "tommy@gmail.com");
		Group group = new Group("Coders");

		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());

		saveAndFindAndDelete(userGroup);
	}
}
