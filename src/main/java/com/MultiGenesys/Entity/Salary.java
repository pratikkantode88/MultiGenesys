package com.MultiGenesys.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private Double ammount;
    
    public Salary() {
		// TODO Auto-generated constructor stub
	}

    
	public Salary(Double ammount) {
		super();
		this.ammount = ammount;
	}


	public Salary(Long id, Double ammount) {
		super();
		this.id = id;
		this.ammount = ammount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", ammount=" + ammount + "]";
	}
    
    
}
