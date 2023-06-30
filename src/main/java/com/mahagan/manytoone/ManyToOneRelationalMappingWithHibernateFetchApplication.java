/**
 * Created By Krishna Shinde
 * Date : 29-06-2023
 * Time : 21:42
 * Project: ManyToOneRelationalMappingWithHibernateSaveAndFetch
 **/

package com.mahagan.manytoone;

import com.mahagan.manytoone.entity.AllStates;
import com.mahagan.manytoone.entity.Country;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class ManyToOneRelationalMappingWithHibernateFetchApplication {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry=new
                StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        TypedQuery typedQuery=session.createQuery("from AllStates allstates");
        List<AllStates> list=typedQuery.getResultList();
        Iterator<AllStates> iterator=list.listIterator();

        while (iterator.hasNext()){
            AllStates allStates=iterator.next();
            System.out.println(allStates.getState_Name()+" "+allStates.getState_code()+" "+
                    allStates.getPopulation());
            Country country=allStates.getCountry();
            System.out.println(country.getCountry_Name()+" "+country.getContinent());

        }
        session.close();
        System.out.println("Data has been successfully retrive");
    }
}


