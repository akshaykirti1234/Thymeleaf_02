package tech.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.csm.model.District;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<District, Integer> {

    @Query("From District where state.stateId = :stateId")
    List<District> getAllDistricts(Integer stateId);

}
