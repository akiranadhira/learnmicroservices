package com.akira.bank.cards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Cards {

    @Column(name = "customer_id")
    private int customerId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "used_amount")
    private int usedAmount;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "create_date")
    private LocalDate createDate;

}
