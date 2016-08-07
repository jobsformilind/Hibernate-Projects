package com.test.hibernate.association.oto.uni.one.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.oto.uni.one.Department;
import com.test.hibernate.association.oto.uni.one.User;
import com.test.hibernate.association.test.BaseTest;

/**
 * CREATE TABLE User ( 
 * 		id bigint(20) NOT NULL AUTO_INCREMENT, 
 * 		Name varchar(255)DEFAULT NULL, 
 * 		deptId int(11) DEFAULT NULL, 
 * 		PRIMARY KEY (id), 
 * 		UNIQUE KEY UK_User_DeptId (deptId), 
 * 		CONSTRAINT FK_User_Dept FOREIGN KEY (deptId) REFERENCES department (id) )
 * 
 * CREATE TABLE Department ( 
 * 		id int(11) NOT NULL AUTO_INCREMENT, 
 * 		Name varchar(255) DEFAULT NULL, 
 * 		PRIMARY KEY (id) 
 * )
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestOneToOneUnidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		Department department = new Department();
		department.setName("Admin");

		User user = new User();
		user.setName("Milind");
		user.setDepartment(department);

		saveAndFindAndDelete(user);
	}
}
