/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.ejb;

import com.autos.model.TblCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juan
 */
@Local
public interface TblCategoriaFacadeLocal {

    void create(TblCategoria tblCategoria);

    void edit(TblCategoria tblCategoria);

    void remove(TblCategoria tblCategoria);

    TblCategoria find(Object id);

    List<TblCategoria> findAll();

    List<TblCategoria> findRange(int[] range);

    int count();
    
}
