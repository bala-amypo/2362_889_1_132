package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SkillRequest;

public interface SkillRequestRepository extends JpaRepository<SkillRequest, Long> {

}