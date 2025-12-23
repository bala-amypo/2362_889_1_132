package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BarterTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SkillMatch match;

    private String status = "INITIATED";

    private Integer offererRating;
    private Integer requesterRating;

    private LocalDateTime completedAt;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillMatch getMatch() {
        return match;
    }

    public void setMatch(SkillMatch match) {
        this.match = match;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOffererRating() {
        return offererRating;
    }

    public void setOffererRating(Integer offererRating) {
        this.offererRating = offererRating;
    }

    public Integer getRequesterRating() {
        return requesterRating;
    }

    public void setRequesterRating(Integer requesterRating) {
        this.requesterRating = requesterRating;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
