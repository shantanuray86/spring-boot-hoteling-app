package com.hoteling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteling.employees.entity.Employee;
import com.hoteling.employees.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
	{
		
		return new ResponseEntity(employeeservice.saveEmployee(employee),HttpStatus.OK);
		
	}
}
