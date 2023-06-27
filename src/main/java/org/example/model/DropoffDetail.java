package org.example.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.*;
import java.util.List;
@Entity
@Table(name = "DROPOFF_DETAIL")
public class DropoffDetail implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "SUPPLIER")
    private Supplier supplier;


    @Column(name = "LATITUDE")
    private Float latitud;

    @Column(name = "LONGITUDE")
    private Float longitud;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String  address3;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "UPDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updt;


    public DropoffDetail() {
    }

    public DropoffDetail(int id,
                         Supplier supplier,
                         Float latitud,
                         Float longitud,
                         String location,
                         String address1,
                         String address2,
                         String address3,
                         String city,
                         String zipCode,
                         String phone,
                         Timestamp updt) {
        this.id = id;
        this.supplier = supplier;
        this.latitud = latitud;
        this.longitud = longitud;
        this.location = location;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.updt = updt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getUpdt() {
        return updt;
    }

    public void setUpdt(Timestamp updt) {
        this.updt = updt;
    }
}
