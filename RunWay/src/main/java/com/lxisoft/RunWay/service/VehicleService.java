package com.lxisoft.RunWay.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {
	@Autowired
	VehicleRepository repo;
	public Vehicle addVehicle(Vehicle vehicle)
	{
		return repo.save(vehicle);
	}
	public List<Vehicle> fetchVehicledetails(String type ,Date date) {
		// TODO Auto-generated method stub
	 
		return repo.getVehicle(type ,date);
	}
	
	public Vehicle updateVehicle(Long id)
	{
	   return repo.findById(id).get();
	}
	
	public Vehicle update(Vehicle vehicle)
	{
		return repo.save(vehicle);
	}
	
	/*public void delete(@PathVariable Long id)
	{
		repo.deleteById(id);
	}*/
	
	public List<Vehicle> viewDetails(@PathVariable Long ownerId)
	{
		return repo.findAllByOwnerId(ownerId);
	}
	public void delete(@PathVariable Long id)
	{
		repo.deleteById(id);
	}
}
