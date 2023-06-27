package org.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "TERMS_CONDITION")
public class TermsCondition implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @ManyToOne
    @JoinColumn(name = "SUPPLIER")
    private Supplier supplier;


    @Column(name = "HEADER")
    private  String header;


    @Column(name = "PARAGRAPH")
    private String paragraph;



    @Column(name = "UPDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updt;


    public TermsCondition() {
    }


    public TermsCondition(int id, Supplier supplier, String header, String paragraph, Timestamp updt) {
        this.id = id;
        this.supplier = supplier;
        this.header = header;
        this.paragraph = paragraph;
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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public Timestamp getUpdt() {
        return updt;
    }

    public void setUpdt(Timestamp updt) {
        this.updt = updt;
    }
}
