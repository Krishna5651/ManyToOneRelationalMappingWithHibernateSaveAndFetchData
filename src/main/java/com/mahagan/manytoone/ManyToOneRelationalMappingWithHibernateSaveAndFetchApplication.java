package com.mahagan.manytoone;


import com.mahagan.manytoone.entity.AllStates;
import com.mahagan.manytoone.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManyToOneRelationalMappingWithHibernateSaveAndFetchApplication {

	public static void main(String[] args) {
		StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().
				configure("hibernate.cfg.xml").build();
		Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();

		AllStates allStates=new AllStates();
		allStates.setState_Name("Maharashtra");
		allStates.setState_code("MH");
		allStates.setPopulation("2.3cr");

		AllStates allStates1=new AllStates();
		allStates1.setState_Name("Gujarat");
		allStates1.setState_code("GU");
		allStates1.setPopulation("1.3cr");

		AllStates allStates2=new AllStates();
		allStates2.setState_Name("Madhya-Pradesh");
		allStates2.setState_code("MP");
		allStates2.setPopulation("1.9cr");

		Country country=new Country();
		country.setCountry_Name("India");
		country.setContinent("Asia");

		allStates.setCountry(country);
		allStates1.setCountry(country);
		allStates2.setCountry(country);

		session.persist(allStates);
		session.persist(allStates1);
		session.persist(allStates2);

		transaction.commit();

		session.close();

		System.out.println("Data has been successfully saved");
	}

}
