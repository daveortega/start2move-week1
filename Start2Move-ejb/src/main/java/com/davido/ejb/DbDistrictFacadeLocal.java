/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbDistrict;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davidortega
 */
@Local
public interface DbDistrictFacadeLocal {

    void create(DbDistrict dbDistrict);

    void edit(DbDistrict dbDistrict);

    void remove(DbDistrict dbDistrict);

    DbDistrict find(Object id);

    List<DbDistrict> findAll();

    List<DbDistrict> findRange(int[] range);

    int count();
    
}
