package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.error.ControllerException;
import com.app.model.CovidCasesBonus;

import com.app.repository.covid.CovidCasesBonusRepository;

import com.app.service.covid.CovidBonusService;
import com.app.service.covid.api.CovidMiningAPITotalCases;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CovidBonusController {

	private  static final String GET_MY_BONUS = "/covid/get/bonus";
	
	private  static final String ADD_COVID_BONUS = "/covid/add/bonus";
	
	private  static final String DELETE_COVID_BONUS = "/covid/delete/bonus";
	
	private  static final String PUT_API_BONUS = "/covid/put/bonus";
	
	private  static final String POST_API_BONUS = "/covid/post/bonus";
	
	private  static final String DELETE_COVID_SOAPUI_BONUS="/covid/deletesoap/bonus";
	private  static final String FIND_DUPLICATE_DELETE_COVID = "/covid/delete/duplicate";

	@Autowired
	CovidBonusService covidBonusService;
	
	@Autowired
	CovidMiningAPITotalCases covidMiningAPITotalCases;
	
	@Autowired
	CovidCasesBonusRepository covidCasesBonusRepository;


	// Objective: to create a set of spring and hibernate services to retrieve data from a new table call "trx_covid_cases_bonus"
	
	// 1. Complete the CovidCasesBonusEntity.java and auto generate a table on DB
	// Enable the line below from application.properties to create new bonus table
	// # spring.jpa.hibernate.ddl-auto=update
	// Then restart application and table being created on the log
	
	// CREATE TABLE / PRIMARY KEY will create implicit index "trx_covid_cases_bonus_pkey" for table "trx_covid_cases_bonus"
	
	// 2. Insert the dummy data into trx_covid_cases_bonus using PGAdmin
	
	// 3. Complete the method below to return list of CovidCasesBonus from table trx_covid_cases_bonus
	// Files to be modified as below
	
	// CovidCasesBonus - Java POJO 
	// CovidCasesBonusEntity - DB Entity File
	// CovidAreaBonusMapper - Mapper from Java Entity file above to POJO 
	// CovidCasesBonusRepository - Spring JPA Repository or library to query DB. i.e. FindAll() method
	// CovidBonusService - Interface for the service below
	// CovidBonusServiceImpl - Implementation of the service between controller and repo
	
	//retrieve data in table
	@GetMapping(GET_MY_BONUS)
	public List<CovidCasesBonus> bonus() throws ControllerException {
		List<CovidCasesBonus> covidCasesBonus = null;
		log.info("bonus() started");

		try {
			covidCasesBonus = covidBonusService.bonus();
			if (covidCasesBonus == null) {
				throw new com.app.error.ControllerException(GET_MY_BONUS,"Not yet Bonus");
			}
		} catch (Exception e) {
			
			log.error("bonus() exception " + e.getMessage());
			throw new com.app.error.ControllerException(e.getMessage(), null);
		}

		log.info(GET_MY_BONUS + " return = {}" + covidCasesBonus);
		return covidCasesBonus;
	}
	
	//Add function

	@GetMapping(ADD_COVID_BONUS)
	public CovidCasesBonus addCovidBonus(@RequestParam(required = true) String desc)  throws ControllerException {
		log.info("addCovid() started={}", desc);
		CovidCasesBonus covidCasesBonus = null;
		try {

			if (desc == null || desc.equals("undefined") || desc.equals(""))  {
				throw new NullPointerException(ADD_COVID_BONUS + ", desc is null or empty");
			}
			covidCasesBonus = covidBonusService.addCovidBonus(desc);
			
		} catch (Exception e) {
		
			log.error("add() exception " + e.getMessage());
			throw new com.app.error.ControllerException(ADD_COVID_BONUS,e.getMessage());		}

		return covidCasesBonus;
	}
	
	//Delete function
	@DeleteMapping(DELETE_COVID_BONUS)
	public int deleteCovidBonus(@RequestParam(required = true) long id)  throws ControllerException {
		log.info("deleteCovid() started id={}", id);
		try {
			return covidBonusService.deleteCovidBonus(id);
			
		}catch (Exception e) {
			
			log.error("add() exception " + e.getMessage());
			throw new com.app.error.ControllerException(DELETE_COVID_BONUS,e.getMessage());
		}
	}
	
	//Update record using put request method
	@PutMapping(PUT_API_BONUS)
	public CovidCasesBonus putCovidBonus(@RequestBody CovidCasesBonus covidCasesBonus) throws ControllerException {

	return covidBonusService.putCovidBonus(covidCasesBonus);
	}
	
	@PostMapping(POST_API_BONUS)
	public CovidCasesBonus postCovidBonus(@RequestBody CovidCasesBonus covidCasesBonus) throws ControllerException {
		return covidBonusService.postCovidBonus(covidCasesBonus);
	}
	
    @DeleteMapping(DELETE_COVID_SOAPUI_BONUS)
    public List<CovidCasesBonus>deleteCovidSoapBonus(@RequestParam(required = true) String desc)throws ControllerException{
		return covidBonusService.deleteCovidBonus(desc);
	}
    
    
	
	@DeleteMapping(FIND_DUPLICATE_DELETE_COVID)
public	List<String> findDuplicateNdelete() throws ControllerException {
		log.info("findDuplicateNdelete() started");
		
		// complete the implementation below
		// ensure logic related to repo move to service implementation
		List<String> e = covidBonusService.deleteDup();
		
		log.info("findDuplicateNdelete() ended");
		return e;
	}

}