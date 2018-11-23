package com.harish.messenger.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.harish.messenger.profiles.ProfileResource;

import messenger.utility.SessionCreater;

public class ProfileService {
	public boolean checkProfile(String profileName) {
		try {
			System.out.println("checking in progress");
			Session session=SessionCreater.getSession();
			Transaction transaction=session.getTransaction();
			transaction.begin();
			
			Query query=session.createSQLQuery("from ProfileResource where profileName = :name");
			query.setParameter("name", profileName);
			List profiles=query.getResultList();
			transaction.commit();
			session.close();
			if(profiles.isEmpty())
				return true;
			else
				return false;
		}
		catch(Exception e) {
			System.out.println("Error in checking ");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public String addProfile(String profileName,String firstName,String lastName) {
		Session session=SessionCreater.getSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		ProfileResource profile=new ProfileResource();
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setProfileName(profileName);
		Date created=new Date();
		profile.setCreated(created);
		return "successfull";
	}
}
