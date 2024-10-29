package fall24.hsf301.service;

import java.util.Scanner;

import fall24.hsf301.pojo.Account;
import fall24.hsf301.pojo.Student;
import fall24.hsf301.repository.AccountRepository;
import fall24.hsf301.repository.IAccountRepository;

public class AccountService implements IAccountService{
		private IAccountRepository iAccountRepository = null;
	public AccountService(String fileName) {
		// TODO Auto-generated constructor stub
		iAccountRepository= new AccountRepository(fileName);
	}
	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return iAccountRepository.findByUserName(userName);
	}
	public Account addAccount() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Account account = new  Account();
		System.out.println("Enter userName: ");
		account.setUserName(sc.nextLine());
		System.out.println("Enter password: ");
		account.setPassWord(sc.nextLine());
		System.out.println("Enter role: ");
		account.setRole(sc.nextLine());
		iAccountRepository.save(account);
		return account;
		
	}

}
