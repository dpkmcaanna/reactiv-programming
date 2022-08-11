package org.reactive.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.reactive.app.dto.Employee;
import org.reactive.app.service.EmployeeService;
import org.reactive.exception.handling.CheckedFunction;
import org.reactive.exception.handling.Either;
import org.reactive.exception.handling.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeControler {

	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		log.info("Received get call to fetch all employee.");
		employeeService.getAll().stream().map(liftWithValue(i -> mapEmp(i))).forEach(System.out::println);
		return employeeService.getAll();
	}
	
	public Employee mapEmp(Employee employee) {
		if(employee.getName().contains("x")) {
			throw new RuntimeException("name has x");
		}
		return employee;
	}
	
	public static <T, R> Function<T, Either> liftWithValue(CheckedFunction<T, R> function) {
		return t -> {
			try {
				return Either.right(function.apply(t));
			} catch(Exception ex) {
				return Either.left(Pair.of(ex, t));
			}
		};
	}
}
