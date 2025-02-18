package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;



    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.find(id);
    }

    @PutMapping("/{customerId}")
    public Account update(@PathVariable Long customerId, @RequestBody Account account) {
        Account existingAccount = accountService.find(account.getId());

        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public Account remove(@PathVariable Long id) {
        Account accountToDelete = accountService.find(id);
        accountService.delete(id);
        return accountToDelete; // Return the account that was deleted
    }

}
