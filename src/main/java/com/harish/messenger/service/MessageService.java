package com.harish.messenger.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.harish.messenger.model.Message;

import messenger.utility.SessionCreater;

public class MessageService {
	public Message getMessage(){
		return null;
		
	}
	public List<Message> getAllMessages(){
		SessionCreater se=new SessionCreater();
		Session session=SessionCreater.getSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		Query query=session.createSQLQuery(toString());
		//query.setParameter(arg0, arg1);
		return null;
		
	}
	public String updateMessage() {
		return null;
		
	}
	public String removeMessage() {
		return null;
		
	}
	public String addMessage() {
		return null;
		
	}
}
