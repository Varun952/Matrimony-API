package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "states")
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @JsonIgnoreProperties("states")
    private Countries countryId;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "currentStateId", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("states")
    private List<Proposals> proposals;

    @OneToMany(mappedBy = "stateId", fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Cities> cities;

    @OneToMany(mappedBy = "permanentState", fetch = FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Proposals> proposals1;


    // constructor
    public States() {

    }

    public States(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    // setters/ getters


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

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }




    // toString

    @Override
    public String toString() {
        return "States{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
