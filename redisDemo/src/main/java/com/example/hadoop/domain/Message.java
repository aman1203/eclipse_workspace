package com.example.hadoop.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="person")
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="age")
	private Integer age;
	@Column(name="sex")
	private String sex;
	@Column(name="email")
	private String email;
	
	public Message() {
		
	}
	
	public Message(String name, String address, Integer age, String sex, String email) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
	public String toString() {
		return "Message [name=" + name + ", address=" + address + ", age=" + age + ", sex=" + sex + ", email=" + email
				+ "]";
	}
	
}
