package com.parinosmaxim.spring.springboot.spring_data_jpa.dao;

import com.parinosmaxim.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Помимо дефолтно доступных методов, можно добавлять свои.
// Spring Boot поможет выбрать название, предложит варианты
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByName(String name);
}
