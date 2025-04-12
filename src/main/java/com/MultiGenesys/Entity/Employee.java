package com.MultiGenesys.Entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    private LocalDate joiningDate;

    @ManyToOne
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    private Salary salary;
    
    public Employee() {
		// TODO Auto-generated constructor stub
	}

	

	public Employee(Long id, String name, Designation designation, LocalDate joiningDate, Department department,
			Salary salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.joiningDate = joiningDate;
		this.department = department;
		this.salary = salary;
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

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	public Salary getSalary() {
		return salary;
	}



	public void setSalary(Salary salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", joiningDate=" + joiningDate
				+ ", department=" + department + "]";
	}
    
    
}
