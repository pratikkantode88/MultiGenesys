package com.MultiGenesys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MultiGenesys.Entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{

}
