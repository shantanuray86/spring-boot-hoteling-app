package com.hoteling.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteling.employees.entity.Employee;
import com.hoteling.employees.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository er;
	
	@Override
	public Object saveEmployee(Employee emp) {
		return er.save(emp);	
	}

}
