package fall24.hsf301.repository;

import fall24.hsf301.dao.AccountDAO;
import fall24.hsf301.pojo.Account;
import fall24.hsf301.pojo.Student;

public class AccountRepository  implements IAccountRepository{
private	AccountDAO accountDAO = null;
	public AccountRepository(String fileConfig) {
		// TODO Auto-generated constructor stub
		accountDAO = new AccountDAO(fileConfig);
	}
	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountDAO.findByUserName(userName);
	}
	public void save(Account account) {
		// TODO Auto-generated method stub
			accountDAO.save(account);
	}
}
