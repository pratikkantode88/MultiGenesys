package com.MultiGenesys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MultiGenesys.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
