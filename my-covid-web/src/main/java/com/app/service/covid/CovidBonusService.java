package com.app.service.covid;
import java.util.List;


import com.app.model.CovidCasesBonus;



public interface CovidBonusService {

	List<CovidCasesBonus> bonus() ;
	
	CovidCasesBonus addCovidBonus(String desc);
	
	int deleteCovidBonus(Long id) ;
	
	CovidCasesBonus putCovidBonus(CovidCasesBonus covidCasesBonus);
	
	CovidCasesBonus postCovidBonus(CovidCasesBonus covidCasesBonus) ;
	
	List<CovidCasesBonus> deleteCovidBonus(String desc) ;

	List<String> deleteDup() ;
	

}