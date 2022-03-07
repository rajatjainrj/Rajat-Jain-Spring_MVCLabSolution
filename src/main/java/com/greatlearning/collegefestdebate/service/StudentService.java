package com.greatlearning.collegefestdebate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.collegefestdebate.model.Student;

@Service
public interface StudentService {

	List<Student> findAll();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);

}
