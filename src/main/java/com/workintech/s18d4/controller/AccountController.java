package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;



    @GetMapping
    public List<AccountResponse> getAllAccounts(){
        List<Account> accounts = accountService.findAll();
        return accounts.stream()
                .map(account -> new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable Long id) {
        Account account = accountService.find(id);
        if (account != null) {
            return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
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
        return accountToDelete;
    }

}
