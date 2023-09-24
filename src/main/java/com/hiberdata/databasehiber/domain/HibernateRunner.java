package com.hiberdata.databasehiber.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateRunner {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("TestManagerEntity");
    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static EntityManager reloadEntityManager(EntityManager entityManager){
        entityManager.close();
        return emf.createEntityManager();
    }


    public void installDataBase(){
        /*
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        emf = Persistence.createEntityManagerFactory("TestManagerEntity");
        EntityManager em = emf.createEntityManager();
        TEST_SPR rrere = em.createQuery("SELECT tesSPR FROM test_spr AS tesSPR where id=7", TEST_SPR.class).getSingleResult();
        TEST_SPR rrr = session.createQuery("SELECT tesSPR FROM test_spr AS tesSPR where id=6",TEST_SPR.class)
                .getSingleResult();
        System.out.println(rrr);
        System.out.println(rrere);

         */
    }






}
