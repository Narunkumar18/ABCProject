package com.RedBusRepos;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.RedBus.Adminlogin;


@Repository
public class AdminloginRepositiryimpl implements Adminloginrepos {
		@PersistenceContext
		EntityManager entityManager;
		@SuppressWarnings("unchecked")
		@Transactional
		public List<Adminlogin> getAllAdminlogins() {
		
		
	List<Adminlogin> r= new ArrayList<Adminlogin>();
	
    Query q = entityManager.createQuery("from Adiminlogin");
	
    r=q.getResultList();
	
	
    return r;
}
		@Transactional//no need of begin transaction and commit rollback
		public void addAdminlogin(Adminlogin eRef) {//usesA
			entityManager.persist(eRef);

		}
		@Transactional
		public Adminlogin findAdminlogin(String email) {//producesA Department obj
			return entityManager.find(Adminlogin.class,email);
			
		}
		@Transactional
		public void modifyAdminlogin(Adminlogin eRef) {
			entityManager.merge(eRef);

		}

		@Transactional
		public void removeAdminlogin(String email) {
			Adminlogin eTemp = entityManager.find(Adminlogin.class,email);
			entityManager.remove(eTemp);
			
		}
		
			
		

	}

