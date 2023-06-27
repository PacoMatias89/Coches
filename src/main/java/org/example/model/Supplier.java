package org.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SUPPLIER")
public class Supplier implements Serializable {
    @Id
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "COUNT")
    private int count;



    @OneToMany(mappedBy = "supplier",cascade = {CascadeType.MERGE, CascadeType.DETACH})
    List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "supplier",cascade = {CascadeType.MERGE, CascadeType.DETACH})
    List<DropoffDetail>dropoffDetails = new ArrayList<>();

    @OneToMany(mappedBy = "supplier",cascade = {CascadeType.MERGE, CascadeType.DETACH})
    List<OpeningHour>openingHours = new ArrayList<>();

    @OneToMany(mappedBy = "supplier",cascade = {CascadeType.MERGE, CascadeType.DETACH})
    List<PickupDetail>pickupDetails = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "supplier_extra",
            joinColumns = @JoinColumn(name = "SUPPLIER"),
            inverseJoinColumns = @JoinColumn(name = "ID_EXTRA"))
    private List<ExtraDetail> extraDetails = new ArrayList<>();

//    @OneToMany(mappedBy = "supplier",cascade = {CascadeType.MERGE, CascadeType.DETACH})
//    List<TermsCondition>termsConditions = new ArrayList<>();

    @Column(name = "UPDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updt;

    public Supplier() {
    }

    public Supplier(String name, String status, int count, Timestamp updt) {
        this.name = name;
        this.status = status;
        this.count = count;
        this.updt = updt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getUpdt() {
        return updt;
    }

    public void setUpdt(Timestamp updt) {
        this.updt = updt;
    }
}
