package org.example.model;

import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "OPENING_HOUR")
public class OpeningHour implements Serializable {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER")
    private Supplier supplier;

    @Column(name = "MON_OPEN")
    private String monOpen;

    @Column(name = "MON_CLOSE")
    private String monClose;

    @Column(name = "TUE_OPEN")
    private String tueOpen;

    @Column(name = "TUE_CLOSE")
    private String tueClose;

    @Column(name = "WED_OPEN")
    private String wedOpen;

    @Column(name = "WED_CLOSE")
    private String wedClose;

    @Column(name = "THU_OPEN")
    private String thuOpen;

    @Column(name = "THU_CLOSE")
    private String thuClose;

    @Column(name = "FRI_OPEN")
    private String friOpen;

    @Column(name = "FRI_CLOSE")
    private String friClose;

    @Column(name = "SAT_OPEN")
    private String satOpen;

    @Column(name = "SAT_CLOSE")
    private String satClose;

    @Column(name = "SUN_OPEN")
    private String suNOpen;

    @Column(name = "SUN_CLOSE")
    private String sunClose;

    @Column(name = "UPDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updt;


    public OpeningHour() {
    }

    public OpeningHour(int id,
                       Supplier supplier,
                       String monOpen,
                       String monClose,
                       String tueOpen,
                       String tueClose,
                       String wedOpen,
                       String wedClose,
                       String thuOpen,
                       String thuClose,
                       String friOpen,
                       String friClose,
                       String satOpen,
                       String satClose,
                       String suNOpen,
                       String sunClose) {
        this.id = id;
        this.supplier = supplier;
        this.monOpen = monOpen;
        this.monClose = monClose;
        this.tueOpen = tueOpen;
        this.tueClose = tueClose;
        this.wedOpen = wedOpen;
        this.wedClose = wedClose;
        this.thuOpen = thuOpen;
        this.thuClose = thuClose;
        this.friOpen = friOpen;
        this.friClose = friClose;
        this.satOpen = satOpen;
        this.satClose = satClose;
        this.suNOpen = suNOpen;
        this.sunClose = sunClose;
    }

    public Timestamp getUpdt() {
        return updt;
    }

    public void setUpdt(Timestamp updt) {
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

    public String getMonOpen() {
        return monOpen;
    }

    public void setMonOpen(String monOpen) {
        this.monOpen = monOpen;
    }

    public String getMonClose() {
        return monClose;
    }

    public void setMonClose(String monClose) {
        this.monClose = monClose;
    }

    public String getTueOpen() {
        return tueOpen;
    }

    public void setTueOpen(String tueOpen) {
        this.tueOpen = tueOpen;
    }

    public String getTueClose() {
        return tueClose;
    }

    public void setTueClose(String tueClose) {
        this.tueClose = tueClose;
    }

    public String getWedOpen() {
        return wedOpen;
    }

    public void setWedOpen(String wedOpen) {
        this.wedOpen = wedOpen;
    }

    public String getWedClose() {
        return wedClose;
    }

    public void setWedClose(String wedClose) {
        this.wedClose = wedClose;
    }

    public String getThuOpen() {
        return thuOpen;
    }

    public void setThuOpen(String thuOpen) {
        this.thuOpen = thuOpen;
    }

    public String getThuClose() {
        return thuClose;
    }

    public void setThuClose(String thuClose) {
        this.thuClose = thuClose;
    }

    public String getFriOpen() {
        return friOpen;
    }

    public void setFriOpen(String friOpen) {
        this.friOpen = friOpen;
    }

    public String getFriClose() {
        return friClose;
    }

    public void setFriClose(String friClose) {
        this.friClose = friClose;
    }

    public String getSatOpen() {
        return satOpen;
    }

    public void setSatOpen(String satOpen) {
        this.satOpen = satOpen;
    }

    public String getSatClose() {
        return satClose;
    }

    public void setSatClose(String satClose) {
        this.satClose = satClose;
    }

    public String getSuNOpen() {
        return suNOpen;
    }

    public void setSuNOpen(String suNOpen) {
        this.suNOpen = suNOpen;
    }

    public String getSunClose() {
        return sunClose;
    }

    public void setSunClose(String sunClose) {
        this.sunClose = sunClose;
    }
}
