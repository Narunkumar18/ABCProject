package com.RedBusRepos;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.RedBus.Adminlogin;


@Repository
public interface Adminloginrepos {
	void addAdminlogin(Adminlogin eRef);
	Adminlogin findAdminlogin(String email);	
	List<Adminlogin> getAllAdminlogins();
	void modifyAdminlogin (Adminlogin  eRef);		
	void removeAdminlogin (String email);

}
