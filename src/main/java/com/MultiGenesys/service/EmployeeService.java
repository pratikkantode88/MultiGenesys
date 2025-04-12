package com.MultiGenesys.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MultiGenesys.Entity.Department;
import com.MultiGenesys.Entity.Designation;
import com.MultiGenesys.Entity.Employee;
import com.MultiGenesys.repository.DepartmentRepository;
import com.MultiGenesys.repository.EmployeeRepository;

@Service
//@RequiredArgsConstructor
public class EmployeeService {

	
    private final EmployeeRepository employeeRepo;
	
	//@Autowired
    private final DepartmentRepository departmentRepo;
	
	
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
		super();
		this.employeeRepo = employeeRepo;
		this.departmentRepo = departmentRepo;
	}

	public Department createDepartment(Department dept) {
        return departmentRepo.save(dept);
    }

    public Employee createEmployee(Long departmentId, Employee emp) {
        Department dept = departmentRepo.findById(departmentId)
            .orElseThrow(() -> new RuntimeException("Dept not found"));
        emp.setDepartment(dept);
        return employeeRepo.save(emp);
    }

    public Page<Employee> getEmployees(Optional<Designation> designation,
                                       Optional<Double> minSalary,
                                       Optional<Double> maxSalary,
                                       int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (designation.isPresent()) {
            return employeeRepo.findByDesignation(designation.get(), pageable);
        }

        if (minSalary.isPresent() && maxSalary.isPresent()) {
            return employeeRepo.findBySalary_AmmountBetween(minSalary.get(), maxSalary.get(), pageable);
        }

        return employeeRepo.findAll(pageable);
    }

    public List<Employee> getEmployeesByDepartment(Long deptId) {
        return employeeRepo.findAll().stream()
            .filter(emp -> emp.getDepartment().getId().equals(deptId))
            .collect(Collectors.toList());
    }
}
