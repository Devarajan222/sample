package com.app.service.covid.api;

import java.util.List;

import com.app.error.ControllerException;
import com.app.model.CovidCasesArea;

public interface CovidMiningAPITotalCases {

	
	List<CovidCasesArea> getLast5RecordsMY() throws ControllerException;

	String getTotalfromDB() throws ControllerException;

	List<CovidCasesArea> getLast5RecordsMYWithSize(int size) throws ControllerException;
}
