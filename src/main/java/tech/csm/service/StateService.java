package tech.csm.service;

import tech.csm.model.State;

import java.util.List;

public interface StateService {

    List<State> getAllState(Integer countryId);

}
