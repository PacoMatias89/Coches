package org.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "SUPPLIER_EXTRA  ")
public class SupplierExtra implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER", referencedColumnName = "NAME", nullable = false)
    private Supplier supplier;


    @ManyToOne
    @JoinColumn(name = "ID_EXTRA", referencedColumnName = "ID", nullable = false)
    private ExtraDetail extraDetail;


    @Column(name = "UPDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updt;


    public SupplierExtra() {
    }

    public SupplierExtra(int id, Supplier supplier, ExtraDetail extraDetail, Timestamp updt) {
        this.id = id;
        this.supplier = supplier;
        this.extraDetail = extraDetail;
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

    public ExtraDetail getExtraDetail() {
        return extraDetail;
    }

    public void setExtraDetail(ExtraDetail extraDetail) {
        this.extraDetail = extraDetail;
    }

    public Timestamp getUpdt() {
        return updt;
    }

    public void setUpdt(Timestamp updt) {
        this.updt = updt;
    }
}
