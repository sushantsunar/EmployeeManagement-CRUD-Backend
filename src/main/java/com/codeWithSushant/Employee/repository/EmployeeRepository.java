package com.codeWithSushant.Employee.repository;

import com.codeWithSushant.Employee.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
