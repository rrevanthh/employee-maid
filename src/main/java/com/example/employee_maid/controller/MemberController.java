package com.example.employee_maid.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_maid.model.MemberDetails;
import com.example.employee_maid.model.UserDetails;
import com.example.employee_maid.repository.MemberRepository;
import com.example.employee_maid.repository.UserDetailsRepository;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}
	
	@GetMapping("/memberlist")
	public List<MemberDetails> getAllMemberDetails(){
		return this.memberRepository.findAll();
	}
	
	@PostMapping("/membercreate")
	public ResponseEntity<MemberDetails> createMemberDetails(@RequestBody MemberDetails member){
		return ResponseEntity.ok().body(this.memberRepository.save(member));		
	}
	@PostMapping("/usercreate")
	public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails userdetail){
		return ResponseEntity.ok().body(this.userDetailsRepository.save(userdetail));
			
	}
	
	@GetMapping("/bymemberid/{id}")
	public String getByMemberId(@PathVariable long id){
		MemberDetails memberDetails;
		Optional<MemberDetails> memberDetail = this.memberRepository.findById(id);
		  if(memberDetail.isPresent()) {
			  memberDetails = memberDetail.get();
		  }else
		  {
			return null;
		  }
	  return  memberDetails.getMemberName();
	}
	
	@PutMapping("/updatebymemberid/{id}")
	public ResponseEntity<MemberDetails> updateMemberDetails(@PathVariable long id, @RequestBody MemberDetails member){
		
		Optional<MemberDetails> memberDetail = this.memberRepository.findById(id);
		if(memberDetail.isPresent()) {
			MemberDetails  updateMemberDetails = memberDetail.get();
			//updateMemberDetails.setMemberId(member.getMemberId());
			updateMemberDetails.setMemberName(member.getMemberName());
			updateMemberDetails.setMemberAddress(member.getMemberAddress());
			
			return ResponseEntity.ok().body(this.memberRepository.save(updateMemberDetails));	
			  
		  }
		return null;
		
	}

}
