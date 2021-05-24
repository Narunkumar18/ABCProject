package com.airbus.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.airbus.pojos.UnAuthorizedTicket;
import com.exceptions.UnAuthorizedIdAlreadyExistsException;
import com.exceptions.UnAuthorizedIdNotFoundException;


@Service
public interface UnAuthService {

	void addUnAuthorizedService(UnAuthorizedTicket uRef)   throws UnAuthorizedIdAlreadyExistsException;
	UnAuthorizedTicket findUnAuthorizedService(Integer unAuthId)   throws UnAuthorizedIdNotFoundException;  
	Set<UnAuthorizedTicket> findUnAuthorizedServices();  		
	void modifyUnAuthorizedService(UnAuthorizedTicket uRef) 	 throws    UnAuthorizedIdNotFoundException;
	void removeUnAuthorizedService(Integer unAuthId)	 throws    UnAuthorizedIdNotFoundException; 
	
}