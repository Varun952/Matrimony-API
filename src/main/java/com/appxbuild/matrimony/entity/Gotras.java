package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gotras")
public class Gotras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDate modified;

    @OneToMany(mappedBy = "gotras", fetch = FetchType.EAGER)
    private List<Proposals> proposals;

    // defalut Constructor
    public Gotras() {

    }

    public Gotras(String name, LocalDateTime created, LocalDate modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    // getters/ setters

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

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

// twoString

    @Override
    public String toString() {
        return "Gotras{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
