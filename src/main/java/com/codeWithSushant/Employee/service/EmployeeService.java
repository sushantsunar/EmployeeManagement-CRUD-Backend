package com.codeWithSushant.Employee.service;

import com.codeWithSushant.Employee.entites.Employee;
import com.codeWithSushant.Employee.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee postEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(long id){
        if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee not found with id: " + id);
        } {

        }
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> optionalEmployee =employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
        }
        return null;
    }
}
