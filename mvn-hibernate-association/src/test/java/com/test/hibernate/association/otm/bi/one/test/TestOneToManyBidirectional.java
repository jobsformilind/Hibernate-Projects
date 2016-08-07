package com.test.hibernate.association.otm.bi.one.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.otm.bi.one.Category;
import com.test.hibernate.association.otm.bi.one.Product;
import com.test.hibernate.association.test.BaseTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestOneToManyBidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		Category category = new Category("Computer");
		Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);
		Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);
		Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);
		Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);

		Set<Product> products = new HashSet<Product>();
		products.add(pc);
		products.add(laptop);
		products.add(phone);
		products.add(tablet);

		category.setProducts(products);

		saveAndFindAndDelete(category);
	}
}
