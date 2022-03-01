/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "tbl_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t"),
    @NamedQuery(name = "TblUsuario.findByUsuId", query = "SELECT t FROM TblUsuario t WHERE t.usuId = :usuId"),
    @NamedQuery(name = "TblUsuario.findByUsuLogin", query = "SELECT t FROM TblUsuario t WHERE t.usuLogin = :usuLogin"),
    @NamedQuery(name = "TblUsuario.findByUsuPassword", query = "SELECT t FROM TblUsuario t WHERE t.usuPassword = :usuPassword")})
public class TblUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuId")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usuLogin")
    private String usuLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usuPassword")
    private String usuPassword;
    @ManyToMany(mappedBy = "tblUsuarioList")
    private List<TblRol> tblRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private List<TblDatospersonales> tblDatospersonalesList;

    public TblUsuario() {
    }

    public TblUsuario(Integer usuId) {
        this.usuId = usuId;
    }

    public TblUsuario(Integer usuId, String usuLogin, String usuPassword) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    @XmlTransient
    public List<TblRol> getTblRolList() {
        return tblRolList;
    }

    public void setTblRolList(List<TblRol> tblRolList) {
        this.tblRolList = tblRolList;
    }

    @XmlTransient
    public List<TblDatospersonales> getTblDatospersonalesList() {
        return tblDatospersonalesList;
    }

    public void setTblDatospersonalesList(List<TblDatospersonales> tblDatospersonalesList) {
        this.tblDatospersonalesList = tblDatospersonalesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuario)) {
            return false;
        }
        TblUsuario other = (TblUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.autos.model.TblUsuario[ usuId=" + usuId + " ]";
    }
    
}
