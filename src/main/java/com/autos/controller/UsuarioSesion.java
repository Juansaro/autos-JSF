/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.controller;

import com.autos.ejb.TblDatospersonalesFacadeLocal;
import com.autos.ejb.TblRolFacadeLocal;
import com.autos.ejb.TblUsuarioFacadeLocal;
import com.autos.model.TblDatospersonales;
import com.autos.model.TblRol;
import com.autos.model.TblUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    @EJB
    private TblUsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    private TblRolFacadeLocal rolFacadeLocal;
    @EJB
    private TblDatospersonalesFacadeLocal datosFacadeLocal;

    @Inject
    private TblRol rol;

    private int fk_rol;
    private String login;
    private String claveIn;

    //Format
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    private List<TblUsuario> usuarios;
    private Collection<TblRol> roles;

    private TblUsuario usuReg = new TblUsuario();
    private TblUsuario usuLog = new TblUsuario();
    private TblUsuario usuTemporal = new TblUsuario();
    private TblDatospersonales datos = new TblDatospersonales();

    @PostConstruct
    public void init() {
        usuarios = usuarioFacadeLocal.findAll();
    }
    
    public void editarDatos(){
        try {
            datosFacadeLocal.edit(datos);
        } catch (Exception e) {
        }
    }

    public void validarUsuario() {
        try {
            int it = 0;
            usuLog = usuarioFacadeLocal.encontrarUsuarioDocumento(login);
            for(TblRol rolIterador: usuLog.getTblRolList()){
                rol = usuLog.getTblRolList().get(it);
                it++;
            }
            it = 0;
            if (usuLog != null) {
                if (usuLog.getUsuLogin().equals(login)) {
                    if (usuLog.getUsuPassword().equals(claveIn)) {
                        switch (rol.toString()) {
                            case "comprador": {
                                FacesContext fc = FacesContext.getCurrentInstance();
                                fc.getExternalContext().redirect("comprador/index.xhtml");
                                datos = usuLog.getTblDatospersonalesList().get(0);
                                break;
                            }
                            case "vendedor": {
                                FacesContext fc = FacesContext.getCurrentInstance();
                                fc.getExternalContext().redirect("vendedor/index.xhtml");
                                datos = usuLog.getTblDatospersonalesList().get(0);
                                break;
                            }
                            default:
                                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                        "No exite",
                                        "No existe"
                                ));
                                break;
                        }

                    }
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error de registro",
                        "Error de registro"
                ));
            }
            rol = new TblRol();

        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error de registro",
                    "Error de registro"
            ));
        }

    }

    public void validarUsuarioSesion() throws IOException {

        if (usuLog == null || usuLog.getUsuLogin() == null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().invalidateSession();
            fc.getExternalContext().redirect("../index.xhtml");
        }
    }

    public void cerrarSesion() throws IOException {
        usuLog = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
        fc.getExternalContext().redirect("../index.xhtml");
    }

    /*
    public void registrarUsuario() {
        usuReg.setContrasena(generatePassayPassword());
        usuTemporal = usuarioFacadeLocal.encontrarUsuarioCorreo(usuReg.getCorreo());
        if (usuTemporal == null) {
            if (usuarioFacadeLocal.registrarUsuario(usuReg, fk_rol)) {
                usuClaveMail.correoReserva(
                        usuReg.getNombre(),
                        usuReg.getApellido(),
                        usuReg.getCorreo(),
                        usuReg.getDocumento(),
                        usuReg.getContrasena()
                );
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Usuario registrado",
                        "Usuario registrado"
                ));
                usuReg = new Usuario();
                usuarios = usuarioFacadeLocal.leerTodos();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error de registro",
                        "Error de registro"
                ));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error de registro",
                        "Error de registro"
                ));
        }
    }
     */
 /*
    public void guardarTemporal(TblUsuario u) {
        usuTemporal = u;
        //fk_rol = u.getFkRol().getIdRol();
    }

    public void actualizarUsuario() {
        try {
            usuarioFacadeLocal.actualizarUsuario(usuTemporal, fk_rol);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Usuario editado",
                    "Usuario editado"
            ));
            usuTemporal = new TblUsuario();
            usuarios = usuarioFacadeLocal.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error de edición",
                    "Error de edición"
            ));
        }
    }

    public void eliminarUsuario(TblUsuario u) {
        try {
            if (usuarioFacadeLocal.eliminarUsuario(u)) {
                usuarios = usuarioFacadeLocal.findAll();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Usuario eliminado",
                        "Usuario eliminado"
                ));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                        "Error de eliminación",
                        "Error de eliminación"
                ));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Error de eliminación",
                    "Error de eliminación"
            ));
        }
    }
     */

    public TblRol getRol() {
        return rol;
    }

    public void setRol(TblRol rol) {
        this.rol = rol;
    }

    public int getFk_rol() {
        return fk_rol;
    }

    public void setFk_rol(int fk_rol) {
        this.fk_rol = fk_rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClaveIn() {
        return claveIn;
    }

    public void setClaveIn(String claveIn) {
        this.claveIn = claveIn;
    }

    public List<TblUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TblUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public TblUsuario getUsuReg() {
        return usuReg;
    }

    public void setUsuReg(TblUsuario usuReg) {
        this.usuReg = usuReg;
    }

    public TblUsuario getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(TblUsuario usuLog) {
        this.usuLog = usuLog;
    }

    public TblUsuario getUsuTemporal() {
        return usuTemporal;
    }

    public void setUsuTemporal(TblUsuario usuTemporal) {
        this.usuTemporal = usuTemporal;
    }

    public Collection<TblRol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<TblRol> roles) {
        this.roles = roles;
    }

    public TblDatospersonales getDatos() {
        return datos;
    }

    public void setDatos(TblDatospersonales datos) {
        this.datos = datos;
    }

}
