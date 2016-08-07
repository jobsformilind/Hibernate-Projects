package com.test.hibernate.association.mtm.bi.one.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.hibernate.association.mtm.bi.one.Author;
import com.test.hibernate.association.mtm.bi.one.Book;
import com.test.hibernate.association.test.BaseTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/*.context.xml" })
public class TestManyToManyBidirectional extends BaseTest {

	@Test
	public void testAssociation() {
		List<Author> authors = new ArrayList<Author>();
		Author author1 = new Author("Milind Patil");
		Author author2 = new Author("Aaryan Patil");
		authors.add(author1);
		authors.add(author2);
		
		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book("Sample 1");
		Book book2 = new Book("Sample 2");
		books.add(book1);
		books.add(book2);

		author1.setBookList(books);
		author2.setBookList(books);

		saveAndFindAndDelete(author1);
		saveAndFindAndDelete(author2);

	}
}
