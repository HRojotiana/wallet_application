package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private String id;
    private String category;
    private String label;
    private LocalDateTime date;
    private String paymentId;

    //Constructor

    public Transaction(String id, String category, String label, LocalDateTime date, String paymentId) {
        this.id = id;
        this.category = category;
        this.label = label;
        this.date = date;
        this.paymentId = paymentId;
    }

    public Transaction() {

    }

    //Getter
    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return LocalDate.from(date);
    }

    public String getLabel() {
        return label;
    }

    public String getPaymentId() {
        return paymentId;
    }

    //Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    //Equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getPaymentId(), that.getPaymentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getLabel(),getDate(), getPaymentId());
    }

    //ToString

    @Override
    public String toString() {
        return "Transaction:" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", label ='" + label + '\'' +
                ", date=" + date +
                ", paymentId='" + paymentId;
    }
}
