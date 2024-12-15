package services;

import java.util.Set;

import entities.Account;

public class AccountService {
	Set<Account> accounts = Set.of(new Account(1L, 0.0), new Account(2L, 0.0));

	public Set<Account> getAccounts() {
		return accounts;
	}
	
}
