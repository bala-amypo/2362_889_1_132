package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MatchRecord;

public interface MatchRecordRepository extends JpaRepository<MatchRecord, Long> {

}