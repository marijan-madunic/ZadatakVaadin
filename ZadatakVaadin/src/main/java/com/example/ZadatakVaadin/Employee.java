package com.example.ZadatakVaadin;

public class Employee {

    private Long id;
    private String firstName, lastName;

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //... setters and getters ... 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Get the value of firstName
	 *
	 * @return the value of firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the value of firstName
	 *
	 * @param firstName
	 *            new value of firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * Get the value of lastName
	 *
	 * @return the value of lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the value of lastName
	 *
	 * @param lastName
	 *            new value of lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}