package com.lxisoft.RunWay.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxisoft.RunWay.model.Customer;
import com.lxisoft.RunWay.model.Owner;
import com.lxisoft.RunWay.model.Vehicle;
import com.lxisoft.RunWay.service.CustomerService;
import com.lxisoft.RunWay.service.OwnerService;

@Controller
public class WebController {
@Autowired
CustomerService cService;
@Autowired
OwnerService oService;
@Autowired
VehicleController vehControl;
@GetMapping("/login")
public String showLogin() {
    return "login";
}
@GetMapping("/registeration")
public String showRegistration() {
    return "registeration";
}
@GetMapping("/customerregister")
public String showCustomerForm(Customer customer) {
    return "customerregister";
}
@PostMapping("/customerregister")
	public String registerCustomerAccount(@ModelAttribute Customer customer,BindingResult result) {


	        if (result.hasErrors()) {
	            return "customerregister";
	        }

	        cService.saveCustomer(customer);
	        return "redirect:/customerregister?success";
	}
@GetMapping("/ownerregister")
public String showOwnerForm(Owner owner) {
    return "ownerregister";
}
@PostMapping("/ownerregister")
	public String registerOwnerAccount(@ModelAttribute Owner owner,BindingResult result) {


	        if (result.hasErrors()) {
	            return "ownerregister";
	        }

	        oService.saveOwner(owner);
	        return "redirect:/ownerregister?success";
	}
@RequestMapping("/CustomerHome")
public String getVehicle(Model model ) {
		  
    
    List<Vehicle> vehicleList = vehControl.readVehicleDetails();
     
 model.addAttribute("vehicleList", vehicleList);
  
 return "CustomerHome" ;
}
@GetMapping("/adminPage")
public String view()
{
	return "adminPage";
}

}
