package in.rohanit.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rohanit.dto.AccountDto;
import in.rohanit.entity.Account;
import in.rohanit.mapper.AccountMapper;
import in.rohanit.repository.AccountRepository;
import in.rohanit.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	
@Override
public AccountDto getAccountById(Long id) {
	// TODO Auto-generated method stub
 Account account = accountRepository
		 .findById(id)
		 .orElseThrow(() ->new RuntimeException("Account not found"));
	return AccountMapper.mapToAccountDto(account);
}

@Override
public AccountDto deposit(Long id, double amount) {
	//check if the account exists in database
	 Account account = accountRepository
			 .findById(id)
			 .orElseThrow(() ->new RuntimeException("Account not found"));
	 
	 double total = account.getBalance() + amount;
	 account.setBalance(total);
	 Account savedAccount = accountRepository.save(account);
	// TODO Auto-generated method stub
	return AccountMapper.mapToAccountDto(savedAccount);
}

@Override
public AccountDto withdraw(Long id, double amount) {
	// TODO Auto-generated method stub
	 Account account = accountRepository
			 .findById(id)
			 .orElseThrow(() ->new RuntimeException("Account not found"));
	 if(account.getBalance() < amount) {
		 throw new RuntimeException("Insufficient amount");
	 }
	 double total = account.getBalance() - amount;
	 account.setBalance(total);
	 Account savedAccount = accountRepository.save(account);
	return AccountMapper.mapToAccountDto(savedAccount);
}

@Override
public List<AccountDto> getAllAccounts() {
	// TODO Auto-generated method stub
	List<Account> accounts = accountRepository.findAll();
	return accounts
			.stream()
			.map( (account) ->AccountMapper.mapToAccountDto(account))
			.collect(Collectors.toList());
}


@Override
public void deleteAccuont(Long id) {
	// TODO Auto-generated method stub
	
	 Account account = accountRepository
			 .findById(id)
			 .orElseThrow(() ->new RuntimeException("Account not found"));
	 
	accountRepository.deleteById(id);
	
}
}
