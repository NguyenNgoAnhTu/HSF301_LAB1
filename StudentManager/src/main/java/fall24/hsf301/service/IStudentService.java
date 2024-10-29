package fall24.hsf301.service;

import java.util.List;

import fall24.hsf301.pojo.Student;



public interface IStudentService {
	public List<Student> findAll();
	public void save(Student student);
	public void delete(Long studentID);
	public Student findById(Long studentID);
	public void update(Student student);
public Student readInformation();
public List<Student>findByFirstName(String firstName);  
}
