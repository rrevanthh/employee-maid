package com.example.employee_maid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_maid.model.MemberDetails;

public interface MemberRepository extends JpaRepository<MemberDetails,Long> {

}
