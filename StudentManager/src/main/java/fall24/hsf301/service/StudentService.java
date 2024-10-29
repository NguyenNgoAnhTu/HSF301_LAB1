package fall24.hsf301.service;

import java.util.List;
import java.util.Scanner;

import fall24.hsf301.dao.JStudentDAO;
import fall24.hsf301.pojo.Student;
import fall24.hsf301.repository.IStudentRepository;
import fall24.hsf301.repository.StudentRepository;

public class StudentService implements IStudentService {

	private IStudentRepository iStudentRepository =null;
	public StudentService(String fileName,int type) {
		// TODO Auto-generated constructor stub
		iStudentRepository = new StudentRepository(fileName,type);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return iStudentRepository.findAll();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		iStudentRepository.save(student);
	}

	@Override
	public void delete(Long studentID) {
		// TODO Auto-generated method stub
		iStudentRepository.delete(studentID);
	}

	@Override
	public Student findById(Long studentID) {
		// TODO Auto-generated method stub
		return iStudentRepository.findById(studentID);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		iStudentRepository.update(student);
	}

	@Override
	public Student readInformation() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student newStudent = new  Student();
		System.out.println("Enter first name: ");
		newStudent.setFirstName(sc.nextLine());
		System.out.println("Enter last name: ");
		newStudent.setLastName(sc.nextLine());
		System.out.println("Enter mark: ");
		newStudent.setMark(sc.nextInt());
		iStudentRepository.save(newStudent);
		return newStudent;
		
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
	return	iStudentRepository.findByFirstName(firstName);
		//return null;
	}

}
