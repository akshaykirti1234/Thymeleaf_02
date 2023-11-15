package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.State;
import tech.csm.repository.StateRepo;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepo stateRepo;

	@Override
	public List<State> getAllState(Integer countryId) {
		// TODO Auto-generated method stub
		return stateRepo.getAllState(countryId);
	}

}
