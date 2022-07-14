package com.greatlearning.studentfest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.greatlearning.studentfest.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
   
}