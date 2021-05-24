package com.airbus.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.pojos.UnAuthorizedTicket;
import com.airbus.service.UnAuthService;
import com.exceptions.UnAuthorizedIdAlreadyExistsException;
import com.exceptions.UnAuthorizedIdNotFoundException;

@RestController
public class UnAuthorizedController {

	@Autowired
	UnAuthService uServ;
	
	@GetMapping(path="/getu/{myid}") //Get Request in Postman http://localhost:8080/getDept/1
	@ResponseBody
	public ResponseEntity<UnAuthorizedTicket> getUnAuthorizedTicket(@PathVariable("myid") Integer unAuthId) throws UnAuthorizedIdNotFoundException {
		UnAuthorizedTicket u = uServ.findUnAuthorizedService(unAuthId);
		UnAuthorizedTicket ua=null;
		ua=uServ.findUnAuthorizedService(unAuthId);
		if(ua==null) {
			
				return ResponseEntity.notFound().build();
		}
			
	 else
	{
		return ResponseEntity.ok(u);}
	
	}
	
	
	@GetMapping(path="/getus")
	@ResponseBody
	public Set<UnAuthorizedTicket> getAllUnAuthorizedServices() {
		System.out.println("Unauth Controller....Understanding client and talking to service layer...");
		Set<UnAuthorizedTicket> uList = uServ.findUnAuthorizedServices();
		return uList;
		
	}
	
	@PostMapping(path="/addu")
	public String addUnAuthorizedService(@RequestBody UnAuthorizedTicket u) {
		try {
			uServ.addUnAuthorizedService(u);
		} catch (UnAuthorizedIdAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@PutMapping(path="/modifyu")
	public String modifyUnAuthorizedService(@RequestBody UnAuthorizedTicket u) {
		try {
			uServ.modifyUnAuthorizedService(u);
		} catch (UnAuthorizedIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@DeleteMapping(path="/deleteu")
	public String deleteUnAuthorizedService(@RequestBody UnAuthorizedTicket u) {
		 try {
			uServ.removeUnAuthorizedService(u.getUnAuthId());
		} catch (UnAuthorizedIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}

	
	
	
         