package com.parinosmaxim.spring.springboot.spring_data_jpa.service;

import com.parinosmaxim.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.parinosmaxim.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;

        // Optional нужен, т.к. return type - Employee
        Optional<Employee> optional = employeeRepository.findById(id);
        // Если в Optional есть работник
        if (optional.isPresent()) {
            employee = optional.get();
        }
         return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);

        return employees;
    }
}
