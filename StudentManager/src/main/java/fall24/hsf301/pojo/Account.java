package fall24.hsf301.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Account {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
	@Column(name="userName")
	private String userName;
	
	@Column(name="passWord")
	private String passWord;

	@Column(name="role")
	private String role;
	public String getUserName() {
		return userName;
	}
	public Account()
	{}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Account( String userName, String passWord, String role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}
//	
	
	
	
}
