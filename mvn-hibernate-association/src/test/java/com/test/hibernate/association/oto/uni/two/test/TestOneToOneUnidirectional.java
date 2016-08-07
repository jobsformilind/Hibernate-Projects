package com.test.hibernate.association.oto.uni.two.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.oto.uni.two.Employee;
import com.test.hibernate.association.oto.uni.two.EmployeeInfo;
import com.test.hibernate.association.test.BaseTest;

/**
 * CREATE TABLE  employee (
 *  Name varchar(255) DEFAULT NULL,
 *  info_id bigint(20) NOT NULL,
 *  PRIMARY KEY (info_id),
 *  CONSTRAINT FK_EMP_EMPINFO FOREIGN KEY (info_id) REFERENCES employeeinfo (id)
 * )
 * 
 * CREATE TABLE  employeeinfo (
 *  id bigint(20) NOT NULL AUTO_INCREMENT,
 *  Name varchar(255) DEFAULT NULL,
 *  PRIMARY KEY (id)
 * )
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestOneToOneUnidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		EmployeeInfo info = new EmployeeInfo();
		info.setName("Patil");

		Employee emp = new Employee();
		emp.setName("Milind");
		emp.setInfo(info);

		saveAndFindAndDelete(emp);
	}
}
