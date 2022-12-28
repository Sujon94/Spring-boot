package com.example.demowebapp.payroll;

import com.example.demowebapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {

}