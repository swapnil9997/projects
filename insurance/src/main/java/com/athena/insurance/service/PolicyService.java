package com.athena.insurance.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.athena.insurance.dto.MemberDto;
import com.athena.insurance.dto.PolicyDetailsDto;
import com.athena.insurance.entities.Policy;
import com.athena.insurance.exception.Error;
import com.athena.insurance.exception.PolicyNotFoundException;
import com.athena.insurance.repository.PolicyRepository;

@Service
public class PolicyService {
	private final String MEMBER_MGMT_SERVICE_NM = "localhost:7099/membermgmtservice";
	private final String MEMBER_MGMT_BASE_URL = "http://" + MEMBER_MGMT_SERVICE_NM + "/";

	private final String MEMBER_DETAILS_URL = MEMBER_MGMT_BASE_URL + "member/{memberNo}/details";

	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Transactional(readOnly = true)
	public PolicyDetailsDto getPolicyDetails(int policyNo) {
		PolicyDetailsDto policyDetailsDto = null;
		Map<String, String> pathVariables = null;
		MemberDto memberDto = null;
		URI resourceURI = null;
		Policy policy = null;

		policy = policyRepository.findById(policyNo).orElseThrow(() -> {
			Error error = new Error();
			error.setErrorCode(1001);
			error.setErrorMessage("Policy Not Found Exception");
			throw new PolicyNotFoundException("policyNot Found", error);
		});

		policyDetailsDto = new PolicyDetailsDto();
		policyDetailsDto.setPolicyNo(policy.getPolicyNo());
		policyDetailsDto.setPolicyStartDate(policy.getPolicyStartDate());
		policyDetailsDto.setPolicyEndDate(policy.getPolicyEndDate());
		policyDetailsDto.setPremiumAmount(policy.getPremiumAmount());
		policyDetailsDto.setInsurredAmount(policy.getInsurredAmount());
		policyDetailsDto.setStatus(policy.getStatus());
		policyDetailsDto.setPlanNo(policy.getPlan().getPlanNo());
		policyDetailsDto.setPlanName(policy.getPlan().getPlanName());
		policyDetailsDto.setMemberNo(policy.getMemberNo());

		pathVariables = new HashMap<>();
		pathVariables.put("memberNo", String.valueOf(policy.getMemberNo()));
		resourceURI = UriComponentsBuilder.fromUriString(MEMBER_DETAILS_URL).build(pathVariables);

		memberDto = restTemplate.getForObject(resourceURI, MemberDto.class);
		policyDetailsDto.setPolicyHolderName(memberDto.getFirstName() + " " + memberDto.getLastName());
		policyDetailsDto.setGender(memberDto.getGender());
		policyDetailsDto.setDob(memberDto.getDob());

		return policyDetailsDto;
	}

}
