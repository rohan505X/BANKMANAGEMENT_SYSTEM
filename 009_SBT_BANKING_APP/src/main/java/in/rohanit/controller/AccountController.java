package in.rohanit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rohanit.dto.AccountDto;
import in.rohanit.service.AccountService;

@RestController
@RequestMapping("/api/accounts")	
public class AccountController {

	@Autowired
	private AccountService accountService;

	//Add account Rest API
	@PostMapping("add_account")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accuontDto){
		
		return new ResponseEntity<>(accountService.createAccount(accuontDto),HttpStatus.CREATED);
	}
	//Get account Rest API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	}
	 
	//Deposit Rest API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
			@RequestBody Map<String,Double>request){
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id,amount );
		return ResponseEntity.ok(accountDto);
	}
	
	//withDraw Rest API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
		@RequestBody Map<String,Double>request){
		
		double amount = request.get("amount");
		AccountDto accountDto = accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	//GET All Accounts Rest API
	@GetMapping("/all")
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
		
	}
	
	//Delete Account Rest API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccuont(id);
		return ResponseEntity.ok( "Account Deleted Successfully");
	}
	
	
}
