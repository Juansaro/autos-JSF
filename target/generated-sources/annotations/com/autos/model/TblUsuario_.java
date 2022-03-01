package com.autos.model;

import com.autos.model.TblDatospersonales;
import com.autos.model.TblRol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-28T21:26:52")
@StaticMetamodel(TblUsuario.class)
public class TblUsuario_ { 

    public static volatile SingularAttribute<TblUsuario, String> usuLogin;
    public static volatile SingularAttribute<TblUsuario, Integer> usuId;
    public static volatile ListAttribute<TblUsuario, TblRol> tblRolList;
    public static volatile SingularAttribute<TblUsuario, String> usuPassword;
    public static volatile ListAttribute<TblUsuario, TblDatospersonales> tblDatospersonalesList;

}