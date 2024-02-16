package com.appxbuild.matrimony.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "types")
public class Types {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "long_desc")
    private String longDesc;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "types", fetch = FetchType.EAGER)
    private List<Users> users;

    // define constructor
    public Types(){

    }
    public Types(String name, String shortDesc, String longDesc, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.created = created;
        this.modified = modified;
    }

    // define getter/setter
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
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

    // define toString() method
    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
