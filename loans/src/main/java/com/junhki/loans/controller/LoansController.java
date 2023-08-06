package com.junhki.loans.controller;

import com.junhki.loans.model.Customer;
import com.junhki.loans.model.Loans;
import com.junhki.loans.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LoansController {

    private final LoansRepository loansRepository;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        final List<Loans> loans = this.loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (Objects.isNull(loans)) {
            return null;
        }
        return loans;
    }

}
