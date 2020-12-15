package com.example.employee_maid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_maid.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
