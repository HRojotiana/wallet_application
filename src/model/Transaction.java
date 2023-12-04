package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private String id;
    private String category;
    private LocalDateTime date;
    private String paymentId;

    //Constructor
    public Transaction(String id, String category, LocalDateTime date, String paymentId) {
        this.id = id;
        this.category = category;
        this.date = date;
        this.paymentId = paymentId;
    }

    //Getter
    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
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

    //Equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getPaymentId(), that.getPaymentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getDate(), getPaymentId());
    }

    //ToString

    @Override
    public String toString() {
        return "Transaction:" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", paymentId='" + paymentId;
    }
}
