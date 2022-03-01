package com.autos.model;

import com.autos.model.TblVehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-28T21:26:52")
@StaticMetamodel(TblCategoria.class)
public class TblCategoria_ { 

    public static volatile SingularAttribute<TblCategoria, Integer> catId;
    public static volatile SingularAttribute<TblCategoria, String> catTipo;
    public static volatile ListAttribute<TblCategoria, TblVehiculo> tblVehiculoList;

}