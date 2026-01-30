package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String portfolioName;

    @Column
    private double totalValue;

    // Each portfolio belongs to one customer
    @ManyToOne
    private Customer customer;

    // One portfolio can have many investments
    @OneToMany(mappedBy = "portfolio")
    private List<Investment> investments;

    // Constructors
    public Portfolio() { }

    public Portfolio(String portfolioName, double totalValue) {
        this.portfolioName = portfolioName;
        this.totalValue = totalValue;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getPortfolioName() { return portfolioName; }
    public double getTotalValue() { return totalValue; }
    public Customer getCustomer() { return customer; }
    public List<Investment> getInvestments() { return investments; }

    public void setPortfolioName(String portfolioName) { this.portfolioName = portfolioName; }
    public void setTotalValue(double totalValue) { this.totalValue = totalValue; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setInvestments(List<Investment> investments) { this.investments = investments; }
}
