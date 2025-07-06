package com.tw.entity;

import java.util.List;

/**
 * NEAT CLASS
 */
public class Expense {
    private String payer;
    private List<String> payees;
    private String expenseName;
    private double amount;

    public Expense() {
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public List<String> getPayees() {
        return payees;
    }

    public void setPayees(List<String> payees) {
        this.payees = payees;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "payer='" + payer + '\'' +
                ", payees=" + payees +
                ", expenseName='" + expenseName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
