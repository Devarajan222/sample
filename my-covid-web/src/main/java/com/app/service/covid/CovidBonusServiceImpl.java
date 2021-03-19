package com.app.service.covid;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CovidCasesBonusEntity;
import com.app.entity.CovidCasesDescEntity;
import com.app.error.IDNotFoundException;
import com.app.mapper.CovidAreaBonusMapper;
import com.app.mapper.CovidAreaDescMapper;
import com.app.model.CovidCasesBonus;
import com.app.model.CovidCasesDesc;
import com.app.repository.covid.CovidCasesRepository;
import com.app.repository.covid.CovidCasesBonusRepository;

import fr.xebia.extras.selma.Selma;
import lombok.extern.slf4j.Slf4j;

//TODO: Practical bonus final
//complete this as Dependencies Injection Service
@Slf4j
@Transactional
@Service
public class CovidBonusServiceImpl implements CovidBonusService {

	// hint
	// the method is similar to getCovidDesc() CovidServiceImpl file
	@Autowired
	CovidCasesBonusRepository covidCasesBonusRepository;
	
	@Override
	public List<CovidCasesBonus> bonus() throws Exception {
		log.info("bonus() started");
		List<CovidCasesBonus> covidCasesBonus = null;
		
		CovidAreaBonusMapper mapper = Selma.builder(CovidAreaBonusMapper.class).build();
		List<CovidCasesBonusEntity> covidCaseBonusEntities = covidCasesBonusRepository.findAll();
		covidCasesBonus = new ArrayList<CovidCasesBonus>();
		
		if (covidCaseBonusEntities == null) {
			throw new IDNotFoundException(0L);
		} else {

			for (CovidCasesBonusEntity entity : covidCaseBonusEntities) {
				CovidCasesBonus model = mapper.asResource(entity);
				covidCasesBonus.add(model);
				log.info("entity desc={}  model desc={}" , entity.getDescription(), model.getDescription());
			}
			log.info(" getCovidDesc() return Size={}", covidCaseBonusEntities.size());
		}

		log.info("bonus() ends covidCasesBonus is null-->" + covidCasesBonus);
		return covidCasesBonus;
	}
	
}