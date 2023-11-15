package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Country;
import tech.csm.repository.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepo countryRepo;

	@Override
	public List<Country> getAllCountry() {
		return countryRepo.findAll();
	}

}
