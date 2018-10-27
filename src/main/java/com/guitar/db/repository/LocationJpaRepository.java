package com.guitar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Location;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

	List<Location> findByStateLike(String stateName);
	
	List<Location> findByStateIgnoreCaseStartingWith(String stateName);

	List<Location> findByStateOrCountry(String value, String value2);

	List<Location> findByStateAndCountry(String value, String value2);

	List<Location> findByStateIsOrCountryEquals(String value, String value2);

	List<Location> findByStateNot(String value);
	
	List<Location> findByStateNotLike(String stateName);
	
	List<Location> findByStateNotLikeOrderByStateAsc(String stateName);
	
	List<Location> findTop5ByStateLike(String value);
	
	List<Location> findDistinctManufacturerByStateLike(String value);
	
	Location findFirstByStateIgnoreCaseIsStartingWith(String stateName);
	
	
	
}
