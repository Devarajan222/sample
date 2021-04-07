package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.error.ControllerException;
import com.app.model.CovidCasesArea;
import com.app.service.covid.api.CovidMiningAPITotalCases;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyCovidController {

	private  static final String GET_MY_LAST_5_COVID = "/covid/get5/my";

	private  static final String MINING_MY_COVID = "/covid/mining/my";
	private  static final String GET_MY_LAST_5_COVID_PARAM = "/covid/get5param/my";


	@Autowired
	CovidMiningAPITotalCases covidMiningAPITotalCases;

	@GetMapping(MINING_MY_COVID)
	public String mining() throws  ControllerException{
		log.info("mining() started");
		String strReturn = null;

		try {
		
		} catch (Exception e) {
			
			log.error("mining() exception " + e.getMessage());
			throw new com.app.error.ControllerException(MINING_MY_COVID,e.getMessage());
		}

		log.info(MINING_MY_COVID + " return = {}" + strReturn);
		return strReturn;
	}

	@GetMapping(GET_MY_LAST_5_COVID)
	public List<CovidCasesArea> getLast5Records() throws ControllerException {
		log.info("getLast5Records() started");

		log.info(
				"getLast5Records() ends. It supposes to return last 5 records from listLast5Records(). (CovidCasesRepository)");
		return covidMiningAPITotalCases.getLast5RecordsMY();
	}
	
	
	// The method below acceping parameter 
	// complete the getLast5RecordsMYWithSize on covidMiningAPITotalCases
	// http://localhost:8081/covid/get5/withsize?size=1
	// Reference - https://howtodoinjava.com/spring-boot2/pagination-sorting-example/
	
	@GetMapping(GET_MY_LAST_5_COVID_PARAM)
	public List<CovidCasesArea> getLast5RecordsWithParam(@RequestParam int size) throws ControllerException {
		log.info("getLast5RecordsWithParam() started size ={}", size);

		log.info(
				"getLast5RecordsWithParam() ends. It supposes to return last 5 records from listLast5Records(). (CovidCasesRepository)");
		return covidMiningAPITotalCases.getLast5RecordsMYWithSize(size);
	}
}
