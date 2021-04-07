package com.app.service.covid;

import java.util.List;

import com.app.error.ControllerException;
import com.app.model.CovidCasesArea;
import com.app.model.CovidCasesDesc;

public interface CovidService {

	List<CovidCasesArea> getCovid();



	List<CovidCasesDesc> getCovidDesc();

	CovidCasesDesc addCovid(String desc);
	
	int deleteCovid(long id);

	CovidCasesDesc putCovid(CovidCasesDesc covidCasesDesc) throws ControllerException;



	int deleteCovidSoap(String desc) throws ControllerException;



	CovidCasesDesc postCovid(CovidCasesDesc covidCasesDesc) throws ControllerException;



	








}
