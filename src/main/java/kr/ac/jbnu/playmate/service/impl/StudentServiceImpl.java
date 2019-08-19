package kr.ac.jbnu.playmate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.playmate.model.Student;
import kr.ac.jbnu.playmate.repository.StudentRepository;
import kr.ac.jbnu.playmate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	
}
