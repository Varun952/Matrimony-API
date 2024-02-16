package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "drinks")
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_code")
    private String shortCode;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "drinks", fetch = FetchType.EAGER)
    private List<Proposals> proposals;

    // default const
    public Drinks() {

    }

    public Drinks(String name, String shortCode, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.shortCode = shortCode;
        this.created = created;
        this.modified = modified;
    }

    //   G/S
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

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    //twoString


    @Override
    public String toString() {
        return "Drinks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
