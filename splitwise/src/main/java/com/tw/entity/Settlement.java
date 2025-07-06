package com.tw.entity;

public class Settlement {
    String whoOwes;
    String owesTo;
    double amount;

    public String getUniqueId(){
        return "%s pays %s".formatted(whoOwes, owesTo);
    }

    public Settlement(String whoOwes, String whom, double amount) {
        this.whoOwes = whoOwes;
        this.owesTo = whom;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isSelfSettlement(){
        return this.whoOwes.equalsIgnoreCase(this.owesTo);
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "whoOwes='" + whoOwes + '\'' +
                ", owesTo='" + owesTo + '\'' +
                ", amount=" + amount +
                '}';
    }

}

