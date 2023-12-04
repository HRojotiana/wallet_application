package model;

import java.util.Objects;

public class Account {
    private String id;
    private String accountName;
    private String accountType;
    private float balance;
    private String currencyId;
    private String transactionId;



    public Account(String id, String accountName, String accountType, float balance, String currencyId, String transactionId) {
        this.id = id;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balance = balance;
        this.currencyId = currencyId;
        this.transactionId = transactionId;
}

    public Account() {

    }


    public String getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public float getBalance() {
        return balance;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}


