package tech.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.csm.model.State;

import java.util.List;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

    @Query("From State s where s.country.countryId = :countryId")
//	@Query(value = "select * from state where country_id = :countryId", nativeQuery = true)
    List<State> getAllState(Integer countryId);

}
