package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BranchProfile;

public interface MatchRecordRepository extends JpaRepository<Match, Long> {

}