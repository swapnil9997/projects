package com.athena.membermgmt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.athena.membermgmt.dto.PolicyMemberDto;
import com.athena.membermgmt.entities.PolicyMember;
import com.athena.membermgmt.exception.PolicyMemberNotFoundException;
import com.athena.membermgmt.repositories.PolicyMemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	private final PolicyMemberRepository policyMemberRepository;

	@Transactional(readOnly = true)
	public PolicyMemberDto getMember(int memberNo) {
		PolicyMemberDto dto = null;

		PolicyMember policyMember = policyMemberRepository.findById(memberNo)
				.orElseThrow(() -> new PolicyMemberNotFoundException("member not found"));
		dto = new PolicyMemberDto();
		BeanUtils.copyProperties(policyMember, dto);
		return dto;
	}

	public MemberService(PolicyMemberRepository policyMemberRepository) {
		super();
		this.policyMemberRepository = policyMemberRepository;
	}
	
	
	
}
