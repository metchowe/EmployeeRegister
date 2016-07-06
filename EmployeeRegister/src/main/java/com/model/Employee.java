package com.model;

public class Employee {
	private int id;
	private String firstName;
	private String lastnName;
	private String birthDay;
	private String gender;

	private Double salary;
	private String hiringDay;

	public Employee(String firstName, String lastnName, String birthDay, String gender) {
		this.firstName = firstName;
		this.lastnName = lastnName;
		this.birthDay = birthDay;
		this.gender = gender;

	}


	public int getID() {
		return id;
	}
	public Employee setID(int id) {
		this.id = id;
		return this;
	}
	public Employee(String firstName) {
		this.firstName = firstName;
	

	}

	public String getFirstName() {
		return firstName;
	}

	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastnName() {
		return lastnName;
	}

	public Employee setLastnName(String lastnName) {
		this.lastnName = lastnName;
		return this;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public Employee setBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public Employee setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public double getSalary() {
		return salary;
	}

	public Employee setSalary(double salary) {
		this.salary = salary;
		return this;
	}

	public String getHiringDay() {
		return hiringDay;
	}

	public Employee setHiringDay(String hiringDay) {
		this.hiringDay = hiringDay;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hiringDay == null) ? 0 : hiringDay.hashCode());
		result = prime * result + ((lastnName == null) ? 0 : lastnName.hashCode());
	

		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (birthDay == null) {
			if (other.birthDay != null)
				return false;
		} else if (!birthDay.equals(other.birthDay))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hiringDay == null) {
			if (other.hiringDay != null)
				return false;
		} else if (!hiringDay.equals(other.hiringDay))
			return false;
		if (lastnName == null) {
			if (other.lastnName != null)
				return false;
		} else if (!lastnName.equals(other.lastnName))
			return false;

		
		return true;
	}

}
