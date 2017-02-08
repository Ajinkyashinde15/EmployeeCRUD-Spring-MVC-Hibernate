package com.crud.rest.dao;

import java.util.List;

import com.crud.rest.beans.MyEmployee;

public interface EmployeeDao {

	MyEmployee findById(long id);

	MyEmployee findByName(String name);

	void saveEmployee(MyEmployee Employee);

	void updateEmployee(MyEmployee Employee);

	void deleteEmployeeById(long id);

	List<MyEmployee> findAllEmployees();

	void deleteAllEmployees();

	boolean isEmployeeExist(MyEmployee Employee);
}
