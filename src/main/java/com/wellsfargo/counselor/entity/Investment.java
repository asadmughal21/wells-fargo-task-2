package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String investmentType;

    @Column
    private double amountInvested;

    // Each investment belongs to one portfolio
    @ManyToOne
    private Portfolio portfolio;

    // One investment can have many transactions
    @OneToMany(mappedBy = "investment")
    private List<Transaction> transactions;

    // Constructors
    public Investment() { }

    public Investment(String investmentType, double amountInvested) {
        this.investmentType = investmentType;
        this.amountInvested = amountInvested;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getInvestmentType() { return investmentType; }
    public double getAmountInvested() { return amountInvested; }
    public Portfolio getPortfolio() { return portfolio; }
    public List<Transaction> getTransactions() { return transactions; }

    public void setInvestmentType(String investmentType) { this.investmentType = investmentType; }
    public void setAmountInvested(double amountInvested) { this.amountInvested = amountInvested; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
}
