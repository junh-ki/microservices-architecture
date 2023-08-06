package com.junhki.accounts.controller;

import com.junhki.accounts.model.Accounts;
import com.junhki.accounts.model.Customer;
import com.junhki.accounts.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AccountsController {

    private final AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        final Accounts accounts = this.accountsRepository.findByCustomerId(customer.getCustomerId());
        if (Objects.isNull(accounts)) {
            return null;
        }
        return accounts;
    }

}
