package com.example.employee_maid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="memberdetails")
public class MemberDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long memberId;
	
	@Column(name = "member_address")
	private String memberAddress;
	
	@Column(name = "member_name")
	private String memberName;

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
		

}
