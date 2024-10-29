package fall24.hsf301.repository;

import fall24.hsf301.pojo.Account;

public interface IAccountRepository {
	public Account findByUserName(String userName);
	public void save(Account account);
}
