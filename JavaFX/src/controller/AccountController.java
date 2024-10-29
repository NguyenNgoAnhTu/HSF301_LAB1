//package controller;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import fall24.hsf301.pojo.Student;
//import fall24.hsf301.service.IStudentService;
//import fall24.hsf301.service.StudentService;
//import javafx.application.Platform;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TablePosition;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TableView.TableViewSelectionModel;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//public class AccountController implements Initializable{
//	//@FXML
//	//private TableView<Student> tbData;
//	
//	private IStudentService iStudentService;
//	@FXML
//	private TableView <Student> tbStudents;
//	@FXML
//	private TableColumn <Student, Long>studentId;
//	@FXML
//	private TableColumn <Student, String>firstName;
//	@FXML
//	private TableColumn <Student, String>lastName;
//	@FXML
//	private TableColumn <Student, Integer>mark;
//	
//	private ObservableList<Student> tableModel;
//	
//	private long idStudent;
//	
//	
//	public long getIdStudent() {
//		return idStudent;
//	}
//
//	public void setIdStudent(long idStudent) {
//		this.idStudent = idStudent;
//	}
//
//	public IStudentService getiStudentService() {
//		return iStudentService;
//	}
//
//	public void setiStudentService(IStudentService iStudentService) {
//		this.iStudentService = iStudentService;
//	}
//
//	public TableView<Student> getTbStudents() {
//		return tbStudents;
//	}
//
//	public void setTbStudents(TableView<Student> tbStudents) {
//		this.tbStudents = tbStudents;
//	}
//
//	public TableColumn<Student, Long> getStudentId() {
//		return studentId;
//	}
//
//	public void setStudentId(TableColumn<Student, Long> studentId) {
//		this.studentId = studentId;
//	}
//
//	public TableColumn<Student, String> getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(TableColumn<Student, String> firstName) {
//		this.firstName = firstName;
//	}
//
//	public TableColumn<Student, String> getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(TableColumn<Student, String> lastName) {
//		this.lastName = lastName;
//	}
//
//	public TableColumn<Student, Integer> getMark() {
//		return mark;
//	}
//
//	public void setMark(TableColumn<Student, Integer> mark) {
//		this.mark = mark;
//	}
//
//	public ObservableList<Student> getTableModel() {
//		return tableModel;
//	}
//
//	public void setTableModel(ObservableList<Student> tableModel) {
//		this.tableModel = tableModel;
//	}
//
//	public TextField getTxtStudentID() {
//		return txtStudentID;
//	}
//
//	public void setTxtStudentID(TextField txtStudentID) {
//		this.txtStudentID = txtStudentID;
//	}
//
//	public TextField getTxtFirstName() {
//		return txtFirstName;
//	}
//
//	public void setTxtFirstName(TextField txtFirstName) {
//		this.txtFirstName = txtFirstName;
//	}
//
//	public TextField getTxtLastname() {
//		return txtLastname;
//	}
//
//	public void setTxtLastname(TextField txtLastname) {
//		this.txtLastname = txtLastname;
//	}
//
//	public TextField getTxtMark() {
//		return txtMark;
//	}
//
//	public void setTxtMark(TextField txtMark) {
//		this.txtMark = txtMark;
//	}
//
//	public AccountController()  {
//		// TODO Auto-generated constructor stub
//		iStudentService = new StudentService("JPAs");
//		tableModel =FXCollections.observableArrayList(iStudentService.findAll());
//	}
//	@SuppressWarnings({"unchecked","rawtypes"})
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//		studentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
//		firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
//		lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
//		mark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
//		tbStudents.setItems(tableModel);
//		
//		tbStudents.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//		@Override
//		public void changed(ObservableValue observableValue ,Object oldValue,Object index) 
//		{
//			if(tbStudents.getSelectionModel().getSelectedItem()!=null)
//			{
//				TableViewSelectionModel selectionModel = tbStudents.getSelectionModel();
//				ObservableList selectedCells = selectionModel.getSelectedCells();
//				TablePosition tablePosition=(TablePosition) selectedCells.get(0);
//				Object studentID=tablePosition.getTableColumn().getCellData(index);
//				try {
//					Student student = iStudentService.findById(Long.valueOf(studentID.toString()));
//					showStudent(student);
//				} catch (Exception e) {
//					// TODO: handle exception
//					showAlert("Information Board!", "Please choose the First Cell!");
//				}
//			}
//			
//		}
//		});
//		
//		
//		
//	}
//	@FXML void btnCancelOnAction()
//	{
//		Platform.exit();
//	}
//	
//	@FXML
//	private TextField txtStudentID;
//	@FXML
//	private TextField txtFirstName;
//	@FXML
//	private TextField txtLastname;
//	@FXML
//	private TextField txtMark;
//	
//	public void showAlert(String header,String content)
//	{
//		Alert alert = new Alert(Alert.AlertType.INFORMATION);
//		alert.setHeaderText(header);
//		alert.setContentText(content);
//		alert.showAndWait();
//		
//	}
//	
//	private void showStudent(Student student)
//	{
//		this.setIdStudent(student.getId());
//		this.txtStudentID.setText(String.valueOf(student.getId()));
//		this.txtFirstName.setText(student.getFirstName());
//		this.txtLastname.setText(student.getLastName());
//		this.txtMark.setText(String.valueOf(student.getMark()));
//	}
//	
//	private void refreshDataTable()
//	{
//		//this.setIdStudent(0);
//		this.txtStudentID.setText("");
//		this.txtFirstName.setText("");
//		this.txtLastname.setText("");
//		this.txtMark.setText("");
//		tableModel=FXCollections.observableArrayList(iStudentService.findAll());
//		tbStudents.setItems(tableModel);
//	}
//	
//	@FXML public void btnAddOnAction()
//	{	//long id = Long.parseLong(txtStudentID.getText());
//		int mark = Integer.parseInt(txtMark.getText());
//		Student st = new Student(txtFirstName.getText(),txtLastname.getText(),mark);
//			iStudentService.save(st);
//			refreshDataTable();
//		
//	}
//	@FXML public void btnUpdateOnAction()
//	{	//this.setIdStudent(Long.parseLong(txtStudentID.getText()));
//		
//		//int mark = Integer.parseInt(txtMark.getText());
//		
//		Student student = new Student();
//		student.setId(Long.parseLong(txtStudentID.getText()));
//		student.setFirstName(txtFirstName.getText());
//		student.setLastName(txtLastname.getText());
//		student.setMark(Integer.parseInt(txtMark.getText()));
//		iStudentService.update(student); 
//		refreshDataTable();
//	}
////	@FXML public void btnDeleteOnAction()
////	{
////		 iStudentService.delete(this.getIdStudent());
////		 refreshDataTable();
////		
////	}
//
//	@FXML public void btnDeleteOnAction() {
//		iStudentService.delete(this.getIdStudent());
//		 refreshDataTable();
//	}
//	
//}




package controller;

import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import fall24.hsf301.pojo.Student;
import fall24.hsf301.service.IStudentService;
import fall24.hsf301.service.StudentService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AccountController implements Initializable{
	@FXML
	private TableView<Student> tbData;
	@FXML
	public TableColumn<Student,Long> studentId;
	@FXML
	public TableColumn<Student, String> firstName;
	@FXML
	public TableColumn<Student, String> lastName;
	@FXML
	public TableColumn<Student, Integer> mark;
	@FXML
	public TextField txtStudentId;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtMark;
	@FXML private  Button btnAdd;
	@FXML private Button btnDelete;
	@FXML private Button btnUpdate;
	@FXML private Button btnCancel;
	@FXML private Button btnSearch;
	private long idStudent;
	private StudentService iStudentService;
	private ObservableList<Student> tableModel;
	private String RoleID;
	
	
	public String getRoleID() {
		return RoleID;
	}
	public void setRoleID(String roleID) {
		this.RoleID = roleID;
		//showAlert("phan quyen " ,String.valueOf(roleID));
		switch(this.RoleID)
		{
		case "ADMIN" : break;
		case "STUDENT" : this.btnDelete.setDisable(true);
						 this.btnAdd.setDisable(true);
						 this.btnUpdate.setDisable(true);
						 break;
						 
		}
	}
	public AccountController() {
		iStudentService = new StudentService("hibernate.cfg.xml",2);
		tableModel = FXCollections.observableArrayList(iStudentService.findAll());
	}
	@FXML public void btnAddStudent() {
		Student student = new Student();
		student.setFirstName(txtFirstName.getText());
		student.setLastName(txtLastName.getText());
		student.setMark(Integer.parseInt(txtMark.getText()));
		System.out.println(student);
		iStudentService.save(student);
		refreshDataTable();
		
	}
	@FXML public void btnUpdateStudent() {
		Student student = new Student();
		this.setIdStudent(Long.parseLong(txtStudentId.getText()));
		student.setId(idStudent);
		student.setFirstName(txtFirstName.getText());
		student.setLastName(txtLastName.getText());
		student.setMark(Integer.parseInt(txtMark.getText()));
		iStudentService.update(student);
		System.out.println(student);
		refreshDataTable();
	}
	@FXML public void btnDeleteStudent() {
		iStudentService.delete(Long.parseLong(txtStudentId.getText()));
		refreshDataTable();
	}
	@FXML public void btnCancel() {
		Platform.exit();
	}
	
	@FXML public void btnSearch()
	{
		
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		studentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		mark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
		tbData.setItems(tableModel);
		tbData.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observableValue, Object oldValue, Object index) {
				if (tbData.getSelectionModel().getSelectedItem() != null) {
						TableViewSelectionModel selectionModel = tbData.getSelectionModel();
					ObservableList selectedCells = selectionModel.getSelectedCells();
					TablePosition tablePosition = (TablePosition) selectedCells.get(0);
					Object studentID = tablePosition.getTableColumn().getCellData(index);
					try {
						Student student = iStudentService.findById(Long.valueOf(studentID.toString())); 
						showStudent(student);
					} catch (Exception ex) { 
						showAlert("Infomation Board!", "Please choose the First Cell !");
					}
				}
				
			}
	});
	}
	public void showAlert(String header, String content) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	

	private void showStudent(Student student) {
		this.txtStudentId.setText(String.valueOf(student.getId()));
		this.txtFirstName.setText(student.getFirstName());
		this.txtLastName.setText(student.getLastName());
		this.txtMark.setText(String.valueOf(student.getMark()));
	}

	private void refreshDataTable() {
		this.txtStudentId.setText("");
		this.txtFirstName.setText("");
		this.txtLastName.setText("");
		this.txtMark.setText("");
		tableModel = FXCollections.observableArrayList(iStudentService.findAll());
		tbData.setItems(tableModel);
	}
	public TableView<Student> getTbData() {
		return tbData;
	}
	public void setTbData(TableView<Student> tbData) {
		this.tbData = tbData;
	}
	public TableColumn<Student, Long> getStudentId() {
		return studentId;
	}
	public void setStudentId(TableColumn<Student, Long> studentId) {
		this.studentId = studentId;
	}
	public TableColumn<Student, String> getFirstName() {
		return firstName;
	}
	public void setFirstName(TableColumn<Student, String> firstName) {
		this.firstName = firstName;
	}
	public TableColumn<Student, String> getLastName() {
		return lastName;
	}
	public void setLastName(TableColumn<Student, String> lastName) {
		this.lastName = lastName;
	}
	public TableColumn<Student, Integer> getMark() {
		return mark;
	}
	public void setMark(TableColumn<Student, Integer> mark) {
		this.mark = mark;
	}
	public TextField getTxtStudentId() {
		return txtStudentId;
	}
	public void setTxtStudentId(TextField txtStudentId) {
		this.txtStudentId = txtStudentId;
	}
	public TextField getTxtLastName() {
		return txtLastName;
	}
	public void setTxtLastName(TextField txtLastName) {
		this.txtLastName = txtLastName;
	}
	public TextField getTxtFirstName() {
		return txtFirstName;
	}
	public void setTxtFirstName(TextField txtFirstName) {
		this.txtFirstName = txtFirstName;
	}
	public TextField getTxtMark() {
		return txtMark;
	}
	public void setTxtMark(TextField txtMark) {
		this.txtMark = txtMark;
	}
	public Long getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(Long idStudent) {
this.idStudent = idStudent;
	}
	public IStudentService getiStudentService() {
		return iStudentService;
	}
	public void setiStudentService(StudentService StudentService) {
		this.iStudentService = StudentService;
	}
	public ObservableList<Student> getTableModel() {
		return tableModel;
	}
	public void setTableModel(ObservableList<Student> tableModel) {
		this.tableModel = tableModel;
	}



}


























