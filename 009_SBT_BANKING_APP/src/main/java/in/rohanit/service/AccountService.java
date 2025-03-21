package in.rohanit.service;

import java.util.List;

import in.rohanit.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id,double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccuont(Long id);

}
