package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_records")
public class MatchRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private UserProfile userA;
    
    @ManyToOne
    private UserProfile userB;
    
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserProfile getUserA() { return userA; }
    public void setUserA(UserProfile userA) { this.userA = userA; }
    public UserProfile getUserB() { return userB; }
    public void setUserB(UserProfile userB) { this.userB = userB; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}