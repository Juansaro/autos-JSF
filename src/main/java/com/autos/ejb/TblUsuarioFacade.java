/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.ejb;

import com.autos.model.TblUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
@Stateless
public class TblUsuarioFacade extends AbstractFacade<TblUsuario> implements TblUsuarioFacadeLocal {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblUsuarioFacade() {
        super(TblUsuario.class);
    }
    
    @Override
    public TblUsuario encontrarUsuarioDocumento(String login){
        Query q = em.createNamedQuery("TblUsuario.findByUsuLogin", TblUsuario.class).setParameter("usuLogin", login);
        
        List<TblUsuario> listado = q.getResultList();
        
        if(!listado.isEmpty()){
            return listado.get(0);
        }
        return null;
    }
    
}
