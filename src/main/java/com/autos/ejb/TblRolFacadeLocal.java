/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.ejb;

import com.autos.model.TblRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface TblRolFacadeLocal {

    void create(TblRol tblRol);

    void edit(TblRol tblRol);

    void remove(TblRol tblRol);

    TblRol find(Object id);

    List<TblRol> findAll();

    List<TblRol> findRange(int[] range);

    int count();
    
}
