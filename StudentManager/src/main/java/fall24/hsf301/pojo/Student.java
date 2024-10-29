package fall24.hsf301.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "firstName",nullable= false,length=50)
	private String firstName;
	@Column(name = "lastName",nullable= false,length=50)
	private String lastName;
	@Column(name="mark")
	private int mark;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Set<Book> books;
	@Override
	public int hashCode() {
		return Objects.hash(id,firstName , lastName, mark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) &&  Objects.equals(lastName, other.lastName)
				&& mark == other.mark;
	}

	public Student() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Student(String firstName, String lastName, int mark) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}

	public Student(long id, String firstName, String lastName, int mark) {
		super();
		this.books=new HashSet<Book>();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mark=" + mark + "]";
	}

}
