/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbLocality;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davidortega
 */
@Local
public interface DbLocalityFacadeLocal {

    void create(DbLocality dbLocality);

    void edit(DbLocality dbLocality);

    void remove(DbLocality dbLocality);

    DbLocality find(Object id);

    List<DbLocality> findAll();

    List<DbLocality> findRange(int[] range);

    int count();
    
}
