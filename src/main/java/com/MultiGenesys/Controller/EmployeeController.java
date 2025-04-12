package com.MultiGenesys.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MultiGenesys.Entity.Department;
import com.MultiGenesys.Entity.Designation;
import com.MultiGenesys.Entity.Employee;
import com.MultiGenesys.service.EmployeeService;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class EmployeeController {

	
    private final EmployeeService service;
	
	@Autowired
    public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/departments")
    public ResponseEntity<Department> createDept(@RequestBody Department dept) {
        return ResponseEntity.ok(service.createDepartment(dept));
    }

    @PostMapping("/departments/{deptId}/employees")
    public ResponseEntity<Employee> createEmp(@PathVariable Long deptId, @RequestBody Employee emp) {
        return ResponseEntity.ok(service.createEmployee(deptId, emp));
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> getEmployees(
            @RequestParam Optional<Designation> designation,
            @RequestParam Optional<Double> minSalary,
            @RequestParam Optional<Double> maxSalary,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(service.getEmployees(designation, minSalary, maxSalary, page, size));
    }

    @GetMapping("/departments/{deptId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByDept(@PathVariable Long deptId) {
        return ResponseEntity.ok(service.getEmployeesByDepartment(deptId));
    }
}
