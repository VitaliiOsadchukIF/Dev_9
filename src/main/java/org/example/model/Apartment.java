package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "area")
    private Float area;

    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;

    @ManyToOne
    @JoinColumn(name = "id_buildings")
    private Building idBuildings;

    public Apartment(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Building getIdBuildings() {
        return idBuildings;
    }

    public void setIdBuildings(Building idBuildings) {
        this.idBuildings = idBuildings;
    }
}
