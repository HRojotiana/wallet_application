package model;

import java.util.Objects;

public class Currency {
    private String id;
    private String currencyCode;
    private String currencyName;
    private String currencySymbol;
    private String exchangeRate;

    //Constructor
    public Currency(String id, String currencyCode, String currencyName, String currencySymbol, String exchangeRate) {
        this.id = id;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.exchangeRate = exchangeRate;
    }

    //Getter
    public String getId() {
        return id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    //Setter

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    //Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency currency)) return false;
        return Objects.equals(getId(), currency.getId()) && Objects.equals(getCurrencyCode(), currency.getCurrencyCode()) && Objects.equals(getCurrencyName(), currency.getCurrencyName()) && Objects.equals(getCurrencySymbol(), currency.getCurrencySymbol()) && Objects.equals(getExchangeRate(), currency.getExchangeRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCurrencyCode(), getCurrencyName(), getCurrencySymbol(), getExchangeRate());
    }

    //ToString
    @Override
    public String toString() {
        return "Currency" +
                "id='" + id + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", exchangeRate='" + exchangeRate;
    }
}
