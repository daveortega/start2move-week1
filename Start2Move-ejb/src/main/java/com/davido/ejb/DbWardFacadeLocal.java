/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbWard;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davidortega
 */
@Local
public interface DbWardFacadeLocal {

    void create(DbWard dbWard);

    void edit(DbWard dbWard);

    void remove(DbWard dbWard);

    DbWard find(Object id);

    List<DbWard> findAll();

    List<DbWard> findRange(int[] range);

    int count();
    
}
