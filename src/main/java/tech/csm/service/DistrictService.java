package tech.csm.service;

import tech.csm.model.District;

import java.util.List;

public interface DistrictService {

    List<District> getAllDistricts(Integer stateId);

}
