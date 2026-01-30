package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    // One customer can have many portfolios
    @OneToMany(mappedBy = "customer")
    private List<Portfolio> portfolios;

    // Each customer can have zero or one financial advisor
    @ManyToOne
    private FinancialAdvisor financialAdvisor;

    // Constructors
    public Customer() { }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Portfolio> getPortfolios() { return portfolios; }
    public FinancialAdvisor getFinancialAdvisor() { return financialAdvisor; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
    public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) { this.financialAdvisor = financialAdvisor; }
}
