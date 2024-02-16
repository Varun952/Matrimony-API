package com.appxbuild.matrimony.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "occupations")
public class Occupations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "icon_name")
    private String iconName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "selected_thumbnail_id")
    private Thumbnails selectedThumbnai;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unselected_thumbnail_id")
    private Thumbnails unselectedThumbnails;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "occupations", fetch = FetchType.EAGER)
    private List<Proposals> proposals;

    // default const
    public Occupations() {}

    public Occupations(String name, String color, String iconName, LocalDateTime created, LocalDateTime modified) {
        this.name = name;
        this.color = color;
        this.iconName = iconName;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
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

    public Thumbnails getThumbnails() {
        return selectedThumbnai;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.selectedThumbnai = thumbnails;
    }

    public Thumbnails getTheThumbnails() {
        return unselectedThumbnails;
    }

    public void setTheThumbnails(Thumbnails theThumbnails) {
        this.unselectedThumbnails = theThumbnails;
    }

    // twoString

    @Override
    public String toString() {
        return "Occupations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", iconName='" + iconName + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
