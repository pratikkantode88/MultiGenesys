package com.MultiGenesys.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MultiGenesys.Entity.Designation;
import com.MultiGenesys.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Page<Employee> findByDesignation(Designation designation, Pageable pageable);
	
    Page<Employee> findBySalary_AmmountBetween(Double min, Double max,Pageable pageable);


}
