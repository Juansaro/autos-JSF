/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.ejb;

import com.autos.model.TblDatospersonales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface TblDatospersonalesFacadeLocal {

    void create(TblDatospersonales tblDatospersonales);

    void edit(TblDatospersonales tblDatospersonales);

    void remove(TblDatospersonales tblDatospersonales);

    TblDatospersonales find(Object id);

    List<TblDatospersonales> findAll();

    List<TblDatospersonales> findRange(int[] range);

    int count();
    
}
