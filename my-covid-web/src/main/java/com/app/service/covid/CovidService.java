package com.app.service.covid;

import java.util.List;

import com.app.model.CovidCasesArea;
import com.app.model.CovidCasesDesc;

public interface CovidService {

	List<CovidCasesArea> getCovid();



	List<CovidCasesDesc> getCovidDesc();

	CovidCasesDesc addCovid(String desc);
	
	int deleteCovid(long id);

	CovidCasesDesc putCovid(CovidCasesDesc covidCasesDesc) throws Exception;



	int deleteCovidSoap(String desc) throws Exception;



	CovidCasesDesc postCovid(CovidCasesDesc covidCasesDesc) throws Exception;



	






	//CovidCasesDesc putCovid(String desc);


}
