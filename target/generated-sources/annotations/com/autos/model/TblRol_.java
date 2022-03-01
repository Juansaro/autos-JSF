package com.autos.model;

import com.autos.model.TblUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-28T21:26:52")
@StaticMetamodel(TblRol.class)
public class TblRol_ { 

    public static volatile SingularAttribute<TblRol, Integer> rolId;
    public static volatile SingularAttribute<TblRol, String> rolTipo;
    public static volatile ListAttribute<TblRol, TblUsuario> tblUsuarioList;

}