package messenger.utility;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionCreater  {
	
	static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	static ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
	
	public static void buildSession() {
		ThreadLocal<Session> sessionThread = new ThreadLocal<Session>();
		sessionThread.set(sessionFactory.openSession());
		
	}
	
	public static Session getSession() {
		
		if (sessionThread == null) {
			Session session = sessionFactory.openSession();
			sessionThread.set(session);
		}
		return sessionThread.get();
		
	}

	
}
