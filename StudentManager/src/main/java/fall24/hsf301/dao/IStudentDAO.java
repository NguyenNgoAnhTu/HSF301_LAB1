package fall24.hsf301.dao;

import java.util.List;

import fall24.hsf301.pojo.Student;

public interface IStudentDAO {
	public List<Student> findAll();
	public void save(Student student);
	public void delete(Long studentID);
	public Student findById(Long studentID);
	public void update(Student student);
	public List<Student>findByFirstName(String firstName);  
}
