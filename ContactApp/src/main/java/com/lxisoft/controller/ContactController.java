package com.lxisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
@RequestMapping(value="/", method = RequestMethod.GET)
public String findAll()
{
	return null;
	
}
		
	
	

}
