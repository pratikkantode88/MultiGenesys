package com.MultiGenesys.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties({"employees"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
    public Department() {
		// TODO Auto-generated constructor stub
	}
   

	public Department(Long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}



	public Department(String name, String location, List<Employee> employees) {
		super();
		this.name = name;
		this.location = location;
		this.employees = employees;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
    
}
