package com.vladimirpandurov.employeemanager4.service;

import com.vladimirpandurov.employeemanager4.exception.UserNotFoundException;
import com.vladimirpandurov.employeemanager4.model.Employee;
import com.vladimirpandurov.employeemanager4.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }


}
