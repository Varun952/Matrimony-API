package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cities")
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals")
    private States stateId;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "currentCityId" , fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnoreProperties("cities")
    private List<Proposals> proposals;

    @OneToMany(mappedBy = "permanentCity" , fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnoreProperties("cities")
    private List<Proposals> proposals1;

    // constructor
    public Cities() {

    }

    public Cities(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    // Setters/ getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public States getStateId() {
        return stateId;
    }

    public void setStateId(States stateId) {
        this.stateId = stateId;
    }


    // toString
    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stateId=" + stateId +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
