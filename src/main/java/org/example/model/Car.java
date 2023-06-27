package org.example.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="CAR")
public class Car implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "STATUS")
    private String status;
    @Column(name = "CATEGORY")
    private int category;
    @Column(name = "SIZE")
    private int size;
    @Column(name = "NAME")
    private String name;
    @Column(name = "URL")
    private String url;
    @Column(name = "LUGGAGE")
    private int luggage;
    @Column(name = "PASSENGER")
    private int passenger;
    @Column(name = "DOORS")
    private int doors;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "TOTAL_CHARGE")
    private float totalCharge;
    @Column(name = "COST")
    private float cost;
    @Column(name = "RATE_QUALIFIER")
    private String rateQualifier;
    @Column(name = "AIRCON")
    private char aircon;
    @Column(name = "AUTOMATIC")
    private char automatic;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER")
    private Supplier supplier;
    @Column(name = "DROP_CHARGE")
    private float dropChanger;
    @Column(name = "ERP")
    private float erp;

    public Car() {
    }

    public Car(String code,
               String status,
               int category,
               int size,
               String name,
               String url,
               int luggage,
               int passenger,
               int doors,
               String currency,
               float totalCharge,
               float cost,
               String rateQualifier,
               char aircon,
               char automatic,
               String type,
               String description,
               Supplier supplier,
               float dropChanger,
               float erp) {
        this.code = code;
        this.status = status;
        this.category = category;
        this.size = size;
        this.name = name;
        this.url = url;
        this.luggage = luggage;
        this.passenger = passenger;
        this.doors = doors;
        this.currency = currency;
        this.totalCharge = totalCharge;
        this.cost = cost;
        this.rateQualifier = rateQualifier;
        this.aircon = aircon;
        this.automatic = automatic;
        this.type = type;
        this.description = description;
        this.supplier = supplier;
        this.dropChanger = dropChanger;
        this.erp = erp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(float totalCharge) {
        this.totalCharge = totalCharge;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getRateQualifier() {
        return rateQualifier;
    }

    public void setRateQualifier(String rateQualifier) {
        this.rateQualifier = rateQualifier;
    }

    public char getAircon() {
        return aircon;
    }

    public void setAircon(char aircon) {
        this.aircon = aircon;
    }

    public char getAutomatic() {
        return automatic;
    }

    public void setAutomatic(char automatic) {
        this.automatic = automatic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public float getDropChanger() {
        return dropChanger;
    }

    public void setDropChanger(float dropChanger) {
        this.dropChanger = dropChanger;
    }

    public float getErp() {
        return erp;
    }

    public void setErp(float erp) {
        this.erp = erp;
    }
}
