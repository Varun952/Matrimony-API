package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "smokes")
public class Smokes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "smokes", fetch = FetchType.EAGER)
    private List<Proposals> proposals;

    // default constructor
    public Smokes() {

    }

    public Smokes(String name, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }


    // setters / getters


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


    // two string

    @Override
    public String toString() {
        return "Smokes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
