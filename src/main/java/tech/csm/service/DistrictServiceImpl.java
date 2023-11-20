package tech.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.csm.model.District;
import tech.csm.repository.DistrictRepo;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepo districtRepo;

    @Override
    public List<District> getAllDistricts(Integer stateId) {
        return districtRepo.getAllDistricts(stateId);
    }

}
