package com.poc.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.springboot.model.OOSProvider;
import com.poc.springboot.service.OOSService;

@RestController
public class OOSController {
	
	@Autowired
	OOSService oosService;
	
	@RequestMapping("/getProviders")
	   public String getProviders() {
	      return "Hello from OOSController";
	   }
	
	@RequestMapping("/getAllProviders")
	   public List<OOSProvider> getAllProviders() {
	      return oosService.retrieveAllOOSProviders();
	   }
	
	
	@RequestMapping("/providers/{providerID}/providerDetails")
	   public OOSProvider getProviderDetails(@PathVariable String providerID) {
	      return oosService.retrieveProvider(providerID);
	   }
	
	@RequestMapping("/providers/{providerID}/deleteProvider")
	   public List<OOSProvider> deleteProviderDetails(@PathVariable String providerID) {
	      return oosService.deleteProvider(providerID);
	   }
	
	@RequestMapping(value = "/addProvider", method = RequestMethod.POST)
    public List<OOSProvider> persistPerson(@RequestBody OOSProvider provider) {
		  
		    return oosService.addProvider(provider);
            
      
    }

}
