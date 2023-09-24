package com.hiberdata.databasehiber.domain;

import javax.persistence.EntityManager;
import java.util.List;


public class RepositoryTestHiber {

    private EntityManager manager = HibernateRunner.getEntityManager();

    public TEST_SPR findTestSprById(){
        return manager.find(TEST_SPR.class,6L);
    }



    public void changeRecord(TEST_SPR selectRecord){
        manager.getTransaction().begin();
        if (selectRecord.getId() != null){
            manager.merge(selectRecord);
        } else {
            manager.persist(selectRecord);
        }
        manager.getTransaction().commit();
    }

    public void removeRecord(TEST_SPR selectRecord){
        manager.getTransaction().begin();
        manager.remove(selectRecord);
        manager.getTransaction().commit();
    }

    public List<TEST_SPR> listTestSpr(){
        manager = HibernateRunner.reloadEntityManager(manager);
        return manager.createQuery("SELECT tesSPR FROM test_spr AS tesSPR",TEST_SPR.class).getResultList();
    }




}
