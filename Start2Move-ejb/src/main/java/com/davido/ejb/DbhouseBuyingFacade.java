/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbhouseBuying;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author davidortega
 */
@Stateless
public class DbhouseBuyingFacade extends AbstractFacade<DbhouseBuying> implements DbhouseBuyingFacadeLocal {

    @PersistenceContext(unitName = "com.davido_Start2Move-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DbhouseBuyingFacade() {
        super(DbhouseBuying.class);
    }

    @Override
    public List<Object[]> findHouseBuy(List<String> listOfPostCodes) {
        String querySTR;
        List<Object[]> resultantList = new ArrayList<>();
        try {
            querySTR = "SELECT MIN(a.buyingPrice), MAX(a.buyingPrice) "
                    + "FROM db_houseBuying a "
                    + "WHERE a.postCodeId IN ?1";
            Query query = em.createNativeQuery(querySTR);
            query.setParameter(1, listOfPostCodes);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

    @Override
    public List<Object[]> getAllHouseBuy(List<String> listOfPostCodes) {
        String querySTR;
        List<Object[]> resultantList = new ArrayList<>();
        try {
            querySTR = "SELECT DISTINCT a.postCodeId, b.postCodeName, buyingPrice "
                    + "FROM db_houseBuying a, db_postCode b "
                    + "WHERE a.postCodeId = b.postCodeId "
                    + "AND a.postCodeLine = b.postCodeLine "
                    + "AND a.postCodeId IN ?1";
            Query query = em.createNativeQuery(querySTR);
            query.setParameter(1, listOfPostCodes);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

    @Override
    public List<DbhouseBuying> findByPostcode(int postcode) {
        String querySTR;
        List<DbhouseBuying> resultantList = new ArrayList<>();
        try {
            querySTR = "FROM DbhouseBuying hb WHERE hb.dbpostCode.dbpostCodePK.postCodeId = ?1";
            Query query = em.createQuery(querySTR);
            query.setParameter(1, postcode);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

}
