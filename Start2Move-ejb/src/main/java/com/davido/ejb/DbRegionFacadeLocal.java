/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbRegion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davidortega
 */
@Local
public interface DbRegionFacadeLocal {

    void create(DbRegion dbRegion);

    void edit(DbRegion dbRegion);

    void remove(DbRegion dbRegion);

    DbRegion find(Object id);

    List<DbRegion> findAll();

    List<DbRegion> findRange(int[] range);

    int count();
    
}
