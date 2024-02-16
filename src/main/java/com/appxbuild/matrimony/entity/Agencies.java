package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "agencies")
public class Agencies {

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_status_id", referencedColumnName = "id")
    @JsonIgnoreProperties("agencies")
    private AgencyStatuses agencyStatuses;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    @OneToMany(mappedBy = "agencies", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agencies")
    private List<AgenciesUsers> agenciesUsers;

    @OneToMany(mappedBy = "agencies", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agencies")
    private List<UserProfiles> userProfiles;

    @OneToMany(mappedBy = "agencies", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agencies")
    private List<Proposals> proposals;

    @OneToMany(mappedBy = "agencies", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agencies")
    private List<Visitors> visitors;
    
    // define constructor
    public Agencies(){

    }

    public Agencies(String name, String shortDesc, String longDesc, AgencyStatuses agencyStatuses, Timestamp created, Timestamp modified) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.agencyStatuses = agencyStatuses;
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

    public AgencyStatuses getAgencyStatuses() {
        return agencyStatuses;
    }

    public void setAgencyStatuses(AgencyStatuses agencyStatuses) {
        this.agencyStatuses = agencyStatuses;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    // define toString() method
    @Override
    public String toString() {
        return "Agencies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", agencyStatuses=" + agencyStatuses +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
