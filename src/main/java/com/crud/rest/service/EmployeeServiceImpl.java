package com.crud.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.beans.MyEmployee;
import com.crud.rest.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public MyEmployee findById(long id) {

		return employeeDao.findById(id);
	}

	@Override
	public MyEmployee findByName(String name) {

		return employeeDao.findByName(name);
	}

	@Override
	public void saveEmployee(MyEmployee Customer) {
		employeeDao.saveEmployee(Customer);

	}

	@Override
	public void updateEmployee(MyEmployee Customer) {
		employeeDao.updateEmployee(Customer);

	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeDao.deleteEmployeeById(id);

	}

	@Override
	public List<MyEmployee> findAllEmployees() {

		return employeeDao.findAllEmployees();
	}

	@Override
	public void deleteAllEmployees() {
		employeeDao.deleteAllEmployees();

	}

	@Override
	public boolean isEmployeeExist(MyEmployee Customer) {

		return employeeDao.isEmployeeExist(Customer);
	}

}
