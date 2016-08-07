package com.test.hibernate.association.mtm.uni.one;

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
@Table(name = "Profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "ProfileToAuthorization",
		joinColumns = @JoinColumn(name = "ProfileId", referencedColumnName = "Id") ,
		inverseJoinColumns = @JoinColumn(name = "AuthoId", referencedColumnName = "Id") )
	private List<Authorization> authoList;

	public Profile() {
	}

	public Profile(String name) {
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

	public List<Authorization> getAuthoList() {
		return authoList;
	}

	public void setAuthoList(List<Authorization> authoList) {
		this.authoList = authoList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profile [id=").append(id).append(", name=").append(name).append("]");
		return builder.toString();
	}
}
