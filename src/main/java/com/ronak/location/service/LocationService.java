package com.ronak.location.service;

import java.util.List;

import com.ronak.location.entities.Location;

public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocaton(Location location);

	void deleteLocaton(Location location);

	Location getLocationById(int id);

	List<Location> getAllLocations();
}
