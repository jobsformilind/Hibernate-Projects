package com.test.hibernate.association.mtm.uni.one.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.mtm.uni.one.Authorization;
import com.test.hibernate.association.mtm.uni.one.Profile;
import com.test.hibernate.association.test.BaseTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestManyToManyUnidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		List<Authorization> authos = new ArrayList<Authorization>();
		authos.add(new Authorization("ADMIN_USER_ADD"));
		authos.add(new Authorization("ADMIN_USER_UPDATE"));
		authos.add(new Authorization("ADMIN_USER_DELETE"));

		Profile profile = new Profile("Admin Profile");
		profile.setAuthoList(authos);

		saveAndFindAndDelete(profile);
	}

	@Test
	public void testSave() {
		List<Authorization> authos = new ArrayList<Authorization>();
		authos.add(new Authorization("ADMIN_USER_ADD"));
		authos.add(new Authorization("ADMIN_USER_UPDATE"));
		authos.add(new Authorization("ADMIN_USER_DELETE"));

		Profile profile = new Profile("Admin Profile");
		profile.setAuthoList(authos);

		save(profile);
	}
}
