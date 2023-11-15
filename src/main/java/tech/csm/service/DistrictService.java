package tech.csm.service;

import java.util.List;

import tech.csm.model.District;

public interface DistrictService {

	List<District> getAllDistricts(Integer stateId);

}
