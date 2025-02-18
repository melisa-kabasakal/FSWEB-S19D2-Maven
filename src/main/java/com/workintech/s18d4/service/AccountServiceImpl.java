package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AccountRepository;
import com.workintech.s18d4.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{


    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account createAccountForCustomer(Long id, Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccountForCustomer(Long id, Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Long id) {
        Account accountToDelete = accountRepository.findById(id).orElse(null);
        if (accountToDelete != null) {
            accountRepository.delete(accountToDelete);
        }
        return accountToDelete;
    }
}
