package com.ronak.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronak.location.entities.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	@Query(value="select type,count(type) from location GROUP BY type",nativeQuery=true)
	public List<Object[]> findTypeandTypeCount();
}
