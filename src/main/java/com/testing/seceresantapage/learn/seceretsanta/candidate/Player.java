package com.testing.seceresantapage.learn.seceretsanta.candidate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	@Column
	private String Number;
	@Column
	private String Address;
	
	public Player() {
		
	}

	public Player(long id, String name, String number, String address) {
		super();
		this.id = id;
		this.name = name;
		Number = number;
		Address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "SeceretSantaPlayer [id=" + id + ", name=" + name + ", Number=" + Number + ", Address=" + Address + "]";
	}
	
	

}
