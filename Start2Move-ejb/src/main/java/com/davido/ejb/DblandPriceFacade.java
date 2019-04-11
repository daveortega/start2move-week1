/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DblandPrice;
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
public class DblandPriceFacade extends AbstractFacade<DblandPrice> implements DblandPriceFacadeLocal {

    @PersistenceContext(unitName = "com.davido_Start2Move-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DblandPriceFacade() {
        super(DblandPrice.class);
    }

    @Override
    public List<Object[]> findLandBuy(List<String> listOfPostCodes) {
        String querySTR;
        List<Object[]> resultantList = new ArrayList<>();
        try {
            querySTR = "SELECT MIN(landPrice), MAX(landPrice) "
                    + "FROM (SELECT ROUND(AVG(a.price)) landPrice "
                    + "FROM db_landPrice a "
                    + "WHERE a.postCode IN ?1 "
                    + "GROUP BY a.postCode) a";
            Query query = em.createNativeQuery(querySTR);
            query.setParameter(1, listOfPostCodes);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

    @Override
    public List<Object[]> getAllLandBuy(List<String> listOfPostCodes) {
        String querySTR;
        List<Object[]> resultantList = new ArrayList<>();
        try {
            querySTR = "SELECT DISTINCT a.postCode, b.postCodeName, ROUND(AVG(a.price)) "
                    + "FROM db_landPrice a, db_postCode b "
                    + "WHERE a.postCode = b.postCodeId "
                    + "AND a.postLine = b.postCodeLine "
                    + "AND a.postCode IN ?1 "
                    + "GROUP BY a.postCode, b.postCodeName "
                    + "ORDER BY 3";
            Query query = em.createNativeQuery(querySTR);
            query.setParameter(1, listOfPostCodes);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

    @Override
    public List<DblandPrice> findByPostcode(int postcode) {
        String querySTR;
        List<DblandPrice> resultantList = new ArrayList<>();
        try {
            querySTR = "FROM DblandPrice lp WHERE lp.dbpostCode.dbpostCodePK.postCodeId = ?1";
            Query query = em.createQuery(querySTR);
            query.setParameter(1, postcode);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

}
