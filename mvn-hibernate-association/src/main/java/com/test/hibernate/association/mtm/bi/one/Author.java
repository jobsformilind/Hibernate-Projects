package com.test.hibernate.association.mtm.bi.one;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "AuthorToBook",
		joinColumns = @JoinColumn(name = "ProfileId", referencedColumnName = "Id") ,
		inverseJoinColumns = @JoinColumn(name = "AuthoId", referencedColumnName = "Id") )
	private List<Book> bookList;

	public Author() {
	}

	public Author(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [id=").append(id);
		builder.append(", name=").append(name);
		builder.append(", bookList=").append(bookList == null ? 0 : bookList.size());
		builder.append("]");
		return builder.toString();
	}
}
