package com.ronak.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronak.location.entities.Location;
import com.ronak.location.repos.LocationRepository;
import com.ronak.location.service.LocationService;
import com.ronak.location.util.EmailUtil;
import com.ronak.location.util.ReportUtil;

@Controller
@RequestMapping("/demo")
public class LocationController {
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ServletContext sc;
	
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "location";	
	}
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap map)
	{
		Location saveLocation = service.saveLocation(location);
		String msg="Location saved with id:-"+saveLocation.getId();
		map.addAttribute("msg", msg);
		emailUtil.sendEmail("er.ronak@hotmail.com", "Location Saved", "location Saved Successfully");
		return "location";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocation(ModelMap map)
	{
		List<Location> allLocations = service.getAllLocations();
		map.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	@RequestMapping("deletedata")
	public String deleteLocation(@RequestParam("id") int id,ModelMap map)
	{
		Location locationById = service.getLocationById(id);
		service.deleteLocaton(locationById);
		List<Location> allLocations = service.getAllLocations();
		map.addAttribute("locations", allLocations);
		return "displayLocations";
	}
	@RequestMapping("/editData")
	public String showUpdate(@RequestParam("id") int id,ModelMap map)
	{
		Location location = service.getLocationById(id);
		map.addAttribute("location", location);
		return "editLocation";
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap map)
	{
		service.updateLocaton(location);
		List<Location> locations = service.getAllLocations();
		map.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeandTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report"; 
	}

	
}

