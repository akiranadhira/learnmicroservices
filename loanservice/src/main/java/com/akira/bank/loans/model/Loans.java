package com.akira.bank.loans.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "account_no")
    @Id
    private long accountNo;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_addr")
    private String branchAddress;

    @Column(name = "create_date")
    private LocalDate createDate;

}
