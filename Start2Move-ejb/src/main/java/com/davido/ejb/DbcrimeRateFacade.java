/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbcrimeRate;
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
public class DbcrimeRateFacade extends AbstractFacade<DbcrimeRate> implements DbcrimeRateFacadeLocal {

    @PersistenceContext(unitName = "com.davido_Start2Move-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DbcrimeRateFacade() {
        super(DbcrimeRate.class);
    }

    @Override
    public List<Object[]> findCrime(List<String> listOfPostCodes) {
        String querySTR;
        List<Object[]> resultantList = new ArrayList<>();
        try {
            querySTR = "SELECT MIN(a.crimeRate), MAX(crimeRate) "
                    + "FROM (SELECT ROUND(AVG(a.crimeRate),1) crimeRate "
                    + "FROM db_crimeRate a, db_locality b "
                    + "WHERE a.municipalityId = b.municipalityId "
                    + "AND b.postCodeId IN ?1 "
                    + "GROUP BY b.postCodeId) a";
            Query query = em.createNativeQuery(querySTR);
            query.setParameter(1, listOfPostCodes);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

    @Override
    public List<Object[]> getAllCrime(List<String> listOfPostCodes) {
        String querySTR;
        List<Object[]> resultantList = new ArrayList<>();
        try {
            querySTR = "SELECT b.postCodeId, c.postCodeName, ROUND(AVG(a.crimeRate),1) "
                    + "FROM db_crimeRate a, db_locality b, db_postCode c "
                    + "WHERE a.municipalityId = b.municipalityId "
                    + "AND b.postCodeId = c.postCodeId "
                    + "AND b.postCodeLine = c.postCodeLine "
                    + "AND b.postCodeId IN ?1 "
                    + "GROUP BY b.postCodeId, c.postCodeName "
                    + "ORDER BY 3";
            Query query = em.createNativeQuery(querySTR);
            query.setParameter(1, listOfPostCodes);
            resultantList = query.getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultantList;
    }

}
