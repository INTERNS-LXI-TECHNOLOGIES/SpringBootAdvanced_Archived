package com.adarsh.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adarsh.entity.*;
import com.adarsh.service.AffidavitService;

@Controller
public class AffidavitController {
	
	@Autowired
	 AffidavitService affidavitService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePageMa()
	{
		return "Home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getadministerationMa()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		if(hasUserRole)
		{
			return "redirect:/displayAll";
		}
		else
		{
			return "User";
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }
	
	@RequestMapping(value = "/apply",method = RequestMethod.GET)
	public ModelAndView appylyAffidavitMa(ModelAndView model)
	{
		AffidavitEntity affidavitEntity = new AffidavitEntity();
        model.addObject("affidavitEntity", affidavitEntity);
        model.setViewName("Apply");
        return model;
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String addQuestion(@ModelAttribute AffidavitEntity entity) {
		
	            affidavitService.saveAffidavit(entity);
	            return "User";
	            
	 }
	 
	 @RequestMapping(value = "/displayAll")
     public ModelAndView getAllAffidavit(ModelAndView model) throws IOException {
        List<AffidavitEntity> listAffidavit = affidavitService.getAllAffidavit();
        model.addObject("listAffidavit", listAffidavit);
        model.setViewName("View");
        return model;
    }
	 
	 @RequestMapping(value = "/approveAffidavit")
     public String approveAffidavit(HttpServletRequest request) throws IOException {
        List<AffidavitEntity> listAffidavit = affidavitService.getAllAffidavit();
        int affidavitId = Integer.parseInt(request.getParameter("id"));
        for(int i =0;i<listAffidavit.size();i++)
        {
        	if(listAffidavit.get(i).getIdMa() == affidavitId)
        	{
        		listAffidavit.get(i).setRejectMa("Approved");
        		affidavitService.saveAffidavit(listAffidavit.get(i));
        	}
        }
        
        return "redirect:/displayAll";
    }
	 
	 @RequestMapping(value = "/cancelAffidavit")
     public String cancelAffidavit(HttpServletRequest request) throws IOException {
        List<AffidavitEntity> listAffidavit = affidavitService.getAllAffidavit();
        int affidavitId = Integer.parseInt(request.getParameter("id"));
        for(int i =0;i<listAffidavit.size();i++)
        {
        	if(listAffidavit.get(i).getIdMa() == affidavitId)
        	{
        		listAffidavit.get(i).setRejectMa("Cancel");
        		affidavitService.saveAffidavit(listAffidavit.get(i));
        	}
        }
        
        return "redirect:/displayAll";
    }
	 
	 @RequestMapping(value = "/checkApproval")
	 public String checkApproval()
	 {
		 return "CheckApproval";
		 
	 }
	 
	 @RequestMapping(value = "/approvalCheck")
     public String checkApproval(HttpServletRequest request) throws IOException {
        List<AffidavitEntity> listAffidavit = affidavitService.getAllAffidavit();
        String phone = request.getParameter("phone");
        HttpSession session = request.getSession(true);
        for(int i =0;i<listAffidavit.size();i++)
        {
        	if(listAffidavit.get(i).getPhoneNumberMa().equals(phone))
        	{
        		session.setAttribute("Match",listAffidavit.get(i).getPhoneNumberMa() );
        	}
        }
        
        return "ApprovedPage";
    }

}
