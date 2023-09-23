package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "property_rights")
    private boolean isEntryAllowed;

    @Column(name = "email")
    private String email;

    @Column(name = "parking")
    private boolean parking;

    @ManyToOne
    @JoinColumn(name = "id_apartments")
    private Apartment apartment;

    public Owner(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEntryAllowed() {
        return isEntryAllowed;
    }

    public void setEntryAllowed(boolean entryAllowed) {
        isEntryAllowed = entryAllowed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
