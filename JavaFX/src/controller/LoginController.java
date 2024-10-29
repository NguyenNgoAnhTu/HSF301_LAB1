package controller;

import java.io.IOException;

import fall24.hsf301.pojo.Account;
import fall24.hsf301.pojo.Student;
import fall24.hsf301.service.AccountService;
import fall24.hsf301.service.IAccountService;
import fall24.hsf301.service.IStudentService;
import fall24.hsf301.service.StudentService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
	private IStudentService studentService;
	private IAccountService accountService;
	public LoginController() {
			accountService = new AccountService("JPAs");
			studentService = new StudentService("hibernate.cfg.xml",2);
			
	}
		@FXML
		private TextField userName;
		
		@FXML
		private PasswordField txtPassword;
		
		@FXML public void loginOnaction() throws IOException {
			String username= userName.getText();
			String password = txtPassword.getText();
			Account account = accountService.findByUserName(userName.getText());
			if(account!=null && account.getPassWord().equals(password))
			{	Stage win =(Stage) userName.getScene().getWindow();
				win.close();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/SMF.fxml"));
				Parent root = loader.load();
				AccountController acController = loader.getController();
				acController.setRoleID(account.getRole());
				Scene scene = new Scene(root);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage primaryStage = new Stage();
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			else {
				
			}
			
			//System.out.println("wrong userName or Password");
		}
		@FXML public void CancelOnAction()
		{
			Platform.exit();
			
		}
		
		
	}


