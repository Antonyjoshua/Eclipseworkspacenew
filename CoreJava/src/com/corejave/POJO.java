package com.corejave;

public class POJO {
//POJO is a basic Java class that focuses purely on storing and accessing data without relying on any frameworks or conventions. It promotes simplicity, flexibility, and reusability in Java applications.
	// Private fields
	private String name;
	private int age;
	private String rollNumber;

	// Default constructor
	public POJO() {
	}

	// Parameterized constructor
	public POJO(String name, int age, String rollNumber) {
		this.name = name;
		this.age = age;
		this.rollNumber = rollNumber;
	}

	// Getter and Setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	// Override toString() for better readability
	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", rollNumber='" + rollNumber + '\'' + '}';
	}

	public static void main(String[] args) {
		// Using parameterized constructor
		POJO student1 = new POJO("John Doe", 20, "A123");

		// Using setters to modify fields
		student1.setAge(21);

		// Accessing fields using getters
		System.out.println("Name: " + student1.getName());
		System.out.println("Age: " + student1.getAge());
		student1.setRollNumber("300");
		System.out.println("Roll Number: " + student1.getRollNumber());

		// Using toString() method
		System.out.println(student1);
	}

}
