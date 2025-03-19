package in.rohanit.mapper;

import in.rohanit.dto.AccountDto;
import in.rohanit.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountdto) {
		Account account = new Account(
				accountdto.getId(),
				accountdto.getAccountHolderName(),
				accountdto.getBalance()
				);
		
		
		return account;
		
		
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		
		
		return accountDto;
		
	}
	 
}
