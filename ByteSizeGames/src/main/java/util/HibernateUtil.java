package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sf;
	private static StandardServiceRegistry registry;
	
	private static SessionFactory getSessionFactory() {
		if(sf == null) {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata meta = sources.getMetadataBuilder().build();
			sf = meta.getSessionFactoryBuilder().build();
		}
		return sf;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
	
	public static void closeSessionFactory() {
		if(sf == null) {
			return;
		}
		sf.close();
	}
}
