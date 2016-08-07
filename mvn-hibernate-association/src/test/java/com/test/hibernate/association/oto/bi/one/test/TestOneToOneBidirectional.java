package com.test.hibernate.association.oto.bi.one.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.oto.bi.one.Invoice;
import com.test.hibernate.association.oto.bi.one.InvoiceOrder;
import com.test.hibernate.association.test.BaseTest;

/**
 * CREATE TABLE  invoice (
 *  id bigint(20) NOT NULL AUTO_INCREMENT,
 *  Name varchar(255) DEFAULT NULL,
 *  orderId bigint(20) NOT NULL,
 *  PRIMARY KEY (id),
 *  UNIQUE KEY UK_INV_OrderId (orderId),
 *  CONSTRAINT FK_INV_Order FOREIGN KEY (orderId) REFERENCES invoiceorder (id)
 * )


 * CREATE TABLE  invoiceorder (
 *  id bigint(20) NOT NULL AUTO_INCREMENT,
 *  OrderName varchar(255) DEFAULT NULL,
 *  PRIMARY KEY (id)
 * )
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestOneToOneBidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		InvoiceOrder order = new InvoiceOrder();
		order.setName("Order One");

		Invoice invoice = new Invoice();
		invoice.setName("Invoice One");
		invoice.setOrder(order);

		saveAndFindAndDelete(invoice);
	}
}
