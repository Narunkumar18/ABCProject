package com.airbus.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.pojos.UnAuthorizedTicket;
import com.airbus.repos.UnAuthorizedTicketRepository;
import com.exceptions.UnAuthorizedIdAlreadyExistsException;
import com.exceptions.UnAuthorizedIdNotFoundException;


@Service
public class UnAuthServiceimpl implements UnAuthService {

	@Autowired
	UnAuthorizedTicketRepository uaRepo;
	
	@Override
	public void addUnAuthorizedService(UnAuthorizedTicket  uRef) throws UnAuthorizedIdAlreadyExistsException{
		// TODO Auto-generated method stub
		try {
		uaRepo.addUnAuthorizedTicket(uRef);
		} catch (Exception e)
		{
			throw new  UnAuthorizedIdAlreadyExistsException(" AuthorizedId Already exists");
		}
	}

	@Override
	public UnAuthorizedTicket  findUnAuthorizedService(Integer unAuthId) throws UnAuthorizedIdNotFoundException {
		// TODO Auto-generated method stub
		
		
		return uaRepo.findUnAuthorizedTicket(unAuthId);
	}

	@Override
	public Set<UnAuthorizedTicket > findUnAuthorizedServices() {
		// TODO Auto-generated method stub
		return uaRepo.findUnAuthorizedTickets();
	}

	@Override
	public void modifyUnAuthorizedService(UnAuthorizedTicket  uRef) throws UnAuthorizedIdNotFoundException {
		
		// TODO Auto-generated method stub
		UnAuthorizedTicket  a =uaRepo.findUnAuthorizedTicket(uRef.getUnAuthId());
		if(a!=null)
		{
		
		uaRepo.modifyUnAuthorizedTicket(uRef);
	}else {
		throw  new UnAuthorizedIdNotFoundException("UnAthorized Id not found");
	}
	}

	@Override
	public void removeUnAuthorizedService(Integer unAuthId) throws UnAuthorizedIdNotFoundException {
		// TODO Auto-generated method stub
		UnAuthorizedTicket a =uaRepo.findUnAuthorizedTicket(unAuthId);
		if(a!=null)
		{
		uaRepo.removeUnAuthorizsedTicket(a.getUnAuthId());
	} else {
		throw  new UnAuthorizedIdNotFoundException("UnAthorized Id not found");
	}
	}
}

	