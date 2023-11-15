package tech.csm.service;

import java.util.List;

import tech.csm.model.State;

public interface StateService {

	List<State> getAllState(Integer countryId);

}
