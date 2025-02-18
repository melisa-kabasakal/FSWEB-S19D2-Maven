package com.workintech.s18d4.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account", schema = "fsweb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private Long id;

    @Column(name="account_name")
    private String accountName;

    @Column(name="money_amount")
    private Double moneyAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;


}
