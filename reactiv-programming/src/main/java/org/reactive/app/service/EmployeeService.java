package org.reactive.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.reactive.app.dto.Employee;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;

@Slf4j
@Service
public class EmployeeService {

	static List<Employee> employees = new ArrayList<Employee>();
	
	public List<Employee> getAll() {
		return employees;
	}
	
	@PostConstruct
	public void setUp() {
		int i = 0;
		while (i++ < 100) {
			employees.add(Employee.builder().name(RandomString.make(5)).salary(34.32).build());	
		}
	}
}
