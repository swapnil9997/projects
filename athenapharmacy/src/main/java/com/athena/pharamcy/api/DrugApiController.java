package com.athena.pharamcy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.pharamcy.dto.DrugDetailsDto;
import com.athena.pharamcy.service.DrugService;

@RestController
@RequestMapping("/drug")
public class DrugApiController {
	@Autowired
	private DrugService drugService;

	@Value("${server.port}")
	private int port;

	@GetMapping(value = "/{drugName}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<DrugDetailsDto> findDrugs(@PathVariable("drugName") String drugName) {
		System.out.println("recieved request by PharamacyService running on port: " + port);
		return drugService.findDrugs(drugName);
	}
}
