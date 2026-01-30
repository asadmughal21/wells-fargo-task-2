package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String transactionType;

    @Column
    private double amount;

    @Column
    private LocalDate transactionDate;

    // Each transaction belongs to one investment
    @ManyToOne
    private Investment investment;

    // Constructors
    public Transaction() { }

    public Transaction(String transactionType, double amount, LocalDate transactionDate) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
    public LocalDate getTransactionDate() { return transactionDate; }
    public Investment getInvestment() { return investment; }

    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setTransactionDate(LocalDate transactionDate) { this.transactionDate = transactionDate; }
    public void setInvestment(Investment investment) { this.investment = investment; }
}
