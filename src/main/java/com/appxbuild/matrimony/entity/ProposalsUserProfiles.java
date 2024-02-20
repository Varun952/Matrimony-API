package com.appxbuild.matrimony.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="proposals_user_profiles")
public class ProposalsUserProfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals_user_profiles")
    private UserProfiles userProfileId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proposal_id", referencedColumnName = "id")
    @JsonIgnoreProperties("proposals_user_profiles")
    private Proposals proposalId;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

//    default constructor
    public ProposalsUserProfiles(){

    }

    public ProposalsUserProfiles(LocalDateTime created, LocalDateTime modified) {
        this.created = created;
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfiles getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(UserProfiles userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Proposals getProposalId() {
        return proposalId;
    }

    public void setProposalId(Proposals proposalId) {
        this.proposalId = proposalId;
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

    // toString
    @Override
    public String toString() {
        return "ProposalsUserProfiles{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
