package com.crud.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.beans.MyEmployee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	//setter for sessionFactory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MyEmployee findById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyEmployee emp = new MyEmployee();
		try {
			emp = (MyEmployee) session.get(MyEmployee.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return emp;
	}

	public MyEmployee findByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyEmployee emp = new MyEmployee();
		String hql = "from com.crud.rest.beans.MyEmployee where name = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, name);
			emp = (MyEmployee) query.uniqueResult();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return emp;
	}

	public void saveEmployee(MyEmployee Employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (Employee != null) {
			try {
				session.save(Employee);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	public void updateEmployee(MyEmployee Employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (Employee != null) {
			try {
				session.update(Employee);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}

		}

	}

	public void deleteEmployeeById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MyEmployee emp = new MyEmployee();
		try {
			emp = (MyEmployee) session.get(MyEmployee.class, id);
			session.delete(emp);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<MyEmployee> findAllEmployees() {
		List<MyEmployee> emp = new ArrayList<MyEmployee>();
		Session session = sessionFactory.openSession();
		emp = session.createQuery("From com.crud.rest.beans.MyEmployee").list();
		return emp;
	}

	
	public void deleteAllEmployees() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.createQuery("delete from MyEmployee").executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}

	}

	public boolean isEmployeeExist(MyEmployee Employee) {
		
			return findByName(Employee.getName())!=null;
	}

}
