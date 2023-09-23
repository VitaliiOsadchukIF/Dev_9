package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Column(name = "roles")
    private String roles;

    @ManyToOne
    @JoinColumn(name = "id_owner")
    private Owner owner;

    public Roles() {

    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
