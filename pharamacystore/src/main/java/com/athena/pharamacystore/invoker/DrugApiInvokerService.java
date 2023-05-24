package com.athena.pharamacystore.invoker;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.athena.pharamacystore.dto.DrugInfo;

@Component
public class DrugApiInvokerService {
	private final String PHARMACY_SERVICE = "PHARMACY-SERVICE";
	private final String SEARCH_DRUG_API_URI = "/drug/{drugName}";

	int lastRoutedInstance;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void init() {
		lastRoutedInstance = -1;
	}

//	public List<ServiceInstance> showPharamacyServiceInstances() {
//		return discoveryClient.getInstances(PHARMACY_SERVICE);
//	}

	public List<DrugInfo> searchDrugsThroughLoadbalancer(String drugName) {
		ResponseEntity<List<DrugInfo>> response = null;
		List<DrugInfo> drugs = null;

		String url = "http://PHARMACY-SERVICE/drug/{drugName}";

		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("drugName", drugName);

		URI uri = UriComponentsBuilder.fromUriString(url).build(pathVariables);
		response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<DrugInfo>>() {
		});
		if (response.getStatusCode() == HttpStatus.OK) {
			drugs = response.getBody();
		}

		return drugs;
	}

	public List<DrugInfo> searchDrugs(String drugName) {
		ResponseEntity<List<DrugInfo>> response = null;
		List<DrugInfo> drugs = null;

		ServiceInstance serviceInstance = loadBalance(PHARMACY_SERVICE);
		String pharmacyServiceBaseURL = serviceInstance.getScheme() + "://" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort();
		String drugEndpoint = pharmacyServiceBaseURL + SEARCH_DRUG_API_URI;

		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("drugName", drugName);

		URI uri = UriComponentsBuilder.fromUriString(drugEndpoint).build(pathVariables);
		response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<DrugInfo>>() {
		});
		if (response.getStatusCode() == HttpStatus.OK) {
			drugs = response.getBody();
		}

		return drugs;
	}

	public ServiceInstance loadBalance(String serviceName) {
		List<ServiceInstance> serviceInstances = null;

		serviceInstances = discoveryClient.getInstances(PHARMACY_SERVICE);

		if (serviceInstances == null || serviceInstances.isEmpty()) {
			throw new RuntimeException("Pharamacy Service is not available");
		}
		if (lastRoutedInstance < serviceInstances.size() - 1) {
			lastRoutedInstance++;
		} else {
			lastRoutedInstance = 0;
		}
		return serviceInstances.get(lastRoutedInstance);

	}

}
