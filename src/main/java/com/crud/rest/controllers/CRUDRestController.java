package com.crud.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.rest.beans.MyEmployee;
import com.crud.rest.service.EmployeeService;

@RestController // combination of @Controller and @ResponseBody annotations
public class CRUDRestController {

	@Autowired
	private EmployeeService employeeService;

	//setter for employeeService
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Add Employee
	@RequestMapping(value = "/employee/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addEmployee(@RequestBody MyEmployee employee, UriComponentsBuilder ucb) {
		if (employeeService.isEmployeeExist(employee)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			employeeService.saveEmployee(employee);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	// Get Single Employee
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyEmployee> getEmployee(@PathVariable("id") int id) {

		MyEmployee employee = employeeService.findById(id);
		if (employee == null) {
			return new ResponseEntity<MyEmployee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MyEmployee>(employee, HttpStatus.OK);
	}

	// Get All Employees
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<MyEmployee>> listAllEmployees() {
		List<MyEmployee> employees = employeeService.findAllEmployees();
		if (employees.isEmpty()) {
			return new ResponseEntity<List<MyEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MyEmployee>>(employees, HttpStatus.OK);
	}

	// Update Employee
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MyEmployee> updateEmployee(@PathVariable("id") int id, @RequestBody MyEmployee emp) {

		MyEmployee employee = employeeService.findById(id);

		if (employee == null) {
			return new ResponseEntity<MyEmployee>(HttpStatus.NOT_FOUND);
		}

		employee.setName(emp.getName());
		employee.setAge(emp.getAge());
		employee.setEmail(emp.getEmail());
		employee.setCity(emp.getCity());
		employee.setEmployer(emp.getEmployer());
		employee.setSalary(emp.getSalary());

		employeeService.updateEmployee(employee);
		return new ResponseEntity<MyEmployee>(employee, HttpStatus.OK);
	}

	// Delete Employee        
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MyEmployee> deleteEmployee(@PathVariable("id") long id) {

		MyEmployee emp = employeeService.findById(id);
		if (emp == null) {
			return new ResponseEntity<MyEmployee>(HttpStatus.NOT_FOUND);
		}

		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<MyEmployee>(HttpStatus.NO_CONTENT);
	}

	// Delete All Employees
	@RequestMapping(value = "/employee/deleteall", method = RequestMethod.DELETE)
	public ResponseEntity<MyEmployee> deleteAllEmployees() {

		employeeService.deleteAllEmployees();
		return new ResponseEntity<MyEmployee>(HttpStatus.NO_CONTENT);
	}
}
