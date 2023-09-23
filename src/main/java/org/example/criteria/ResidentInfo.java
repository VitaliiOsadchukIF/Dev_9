package org.example.criteria;

public class ResidentInfo {

    private int id;
    private String name;
    private String email;
    private String buildingAddress;
    private int apartmentNumber;
    private float apartmentArea;


    public ResidentInfo(int id, String name, String email, String buildingAddress,
                        int apartmentNumber, float apartmentArea) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.buildingAddress = buildingAddress;
        this.apartmentNumber = apartmentNumber;
        this.apartmentArea = apartmentArea;
    }

    @Override
    public String toString() {
        return "ResidentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", buildingAddress='" + buildingAddress + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                ", apartmentArea=" + apartmentArea +
                '}';
    }
}
