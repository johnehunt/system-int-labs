package com.jjh.books;

public class Publisher implements PrettyPrinter {
	
	private String name;
	private Address address;

	public Publisher() {}

	public Publisher(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("Publisher [name=%s, address=%s]", name, address);
	}

	@Override
	public void prettyPrint() {
		System.out.println(String.format("Publisher [name=%s, address=%s]", name, address));
	}
	
}
