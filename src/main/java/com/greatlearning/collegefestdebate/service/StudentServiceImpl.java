package com.greatlearning.collegefestdebate.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.collegefestdebate.model.Student;

@Repository
public class StudentServiceImpl implements StudentService {
	
	private SessionFactory sessionFactory;

	// create session
	private Session session;
	
	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}


	}

	@Override
	public List<Student> findAll() {
		List<Student> students = session.createQuery("from Student").list();
		return students;
	}

	@Override
	public Student findById(int id) {
		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	public void save(Student student) {
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(student);


		tx.commit();
	}

	@Override
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class, id);

		// delete record
		session.delete(student);

		tx.commit();
		
	}

}
