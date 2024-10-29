package fall24.hsf301.repository;

import java.util.List;

import fall24.hsf301.dao.HStudentDAO;
import fall24.hsf301.dao.IStudentDAO;
import fall24.hsf301.dao.JStudentDAO;
import fall24.hsf301.pojo.Student;

public class StudentRepository implements IStudentRepository{

	private IStudentDAO studentDAO;
	public StudentRepository(String fileConfig,int type) {
		if (type==1)
		{		
		studentDAO = new JStudentDAO(fileConfig);
		}
		else {
			
		studentDAO = new HStudentDAO(fileConfig);
	}}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDAO.findAll();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
			studentDAO.save(student);
	}

	@Override
	public void delete(Long studentID) {
		// TODO Auto-generated method stub
		studentDAO.delete(studentID);
	}

	@Override
	public Student findById(Long studentID) {
		// TODO Auto-generated method stub
		return studentDAO.findById(studentID);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDAO.update(student);
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		List<Student> list = null;
		list=studentDAO.findByFirstName(firstName);
		return list;
	}
	
	
}
