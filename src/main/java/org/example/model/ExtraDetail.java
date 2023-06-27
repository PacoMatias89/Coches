package org.example.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "EXTRA_DETAIL")
public class ExtraDetail implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column( name = "NAME")
    private String name;



    @Column(name ="SUPPLIER_CODE")
    private String supplierCode;

    @Column(name ="PRICE")
    private float price;

    @Column(name = "PERIOD")
    private String period;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "MAX_AMOUNT")
    private int maxAmount;

    @Column(name = "INFORMATION")
    private String information;

    public ExtraDetail() {
    }

    public ExtraDetail(int id,
                       String name,
                       String supplierCode,
                       float price,
                       String period,
                       String currency,
                       int maxAmount,
                       String informatio) {
        this.id = id;
        this.name = name;
        this.supplierCode = supplierCode;
        this.price = price;
        this.period = period;
        this.currency = currency;
        this.maxAmount = maxAmount;
        this.information = informatio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String informatio) {
        this.information = informatio;
    }
}
