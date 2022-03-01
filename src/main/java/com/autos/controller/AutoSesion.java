/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autos.controller;

import com.autos.ejb.TblCategoriaFacadeLocal;
import com.autos.ejb.TblUsuarioFacadeLocal;
import com.autos.ejb.TblVehiculoFacadeLocal;
import com.autos.model.TblCategoria;
import com.autos.model.TblDatospersonales;
import com.autos.model.TblVehiculo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author juan
 */

@Named( value = "autoSesion" )
@SessionScoped
public class AutoSesion implements Serializable{
    
    @EJB
    private TblVehiculoFacadeLocal vehiculoEjb;
    @EJB
    private TblCategoriaFacadeLocal categoriaEjb;
    @EJB
    private TblUsuarioFacadeLocal usuarioEjb;
    
    private TblVehiculo vehiculo;
    private TblVehiculo vehiculoTemporal;
    private TblVehiculo vehiculoFiltro;
    
    private Integer fk_categoria;
    private Short estado;
    private int desde;
    private int hasta;
    
    @Inject
    private TblCategoria cat;
    @Inject
    private UsuarioSesion usuSesion;
    @Inject
    private TblDatospersonales datoPersonal;
    
    private List<TblCategoria> categorias;
    private List<TblVehiculo> vehiculos;
    private List<TblVehiculo> vehiculosLista = new ArrayList<>();
    private List<TblVehiculo> vehiculosFiltrados = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        vehiculo = new TblVehiculo();
        vehiculoTemporal = new TblVehiculo();
        vehiculoFiltro = new TblVehiculo();
        cat = new TblCategoria();
        categorias = categoriaEjb.findAll();
    }
    
    public void listarCategoria(){
        vehiculos = vehiculoEjb.filtrarVehiculosCategoria(cat);       
        if(!vehiculos.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "Filtro exitoso",
                                        "Filtro exitoso"
                                ));
        }
        
        if(vehiculos.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "No hay automóviles en esa categoria",
                                        "No hay automóviles en esa categoria"
                                ));
        }
    }
    
    public void cargarVendedor(TblVehiculo vehIn){
        vehiculoTemporal = vehIn;
    }
    
    public void registrarVehiculo(){
        try {
            //cat.setCatId(fk_categoria);
            /*vehiculo.setDatId(usuSesion.getUsuLog().getTblDatospersonalesList().get(0));
            vehiculo.setCatId(cat);
            vehiculo.setVehEstado(estado);*/
            vehiculoEjb.registrarVehiculo(vehiculo, estado, fk_categoria, usuSesion.getUsuLog().getTblDatospersonalesList().get(0));
            
            vehiculos = vehiculoEjb.findAll();
            cat = new TblCategoria();
            vehiculo = new TblVehiculo();
            fk_categoria = 0;
            estado = 0;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "Vehículo registrado",
                                        "Vehíxulo registrado"
                                ));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                        "Error de registro",
                                        "Error de registro"
                                ));
        }
    }

    public void cambiarEstado(TblVehiculo vehIn) {
        if (vehIn.getVehEstado() == Short.parseShort("0")) {
            vehIn.setVehEstado(Short.parseShort("1"));
        } else {
            vehIn.setVehEstado(Short.parseShort("0"));
        }
        vehiculoEjb.edit(vehIn);
    }

    public void filtrarRangoPrecio(){
        int iterador = 0;
        vehiculosLista = vehiculoEjb.findAll();
        vehiculoFiltro =  new TblVehiculo();
        vehiculos.clear();
        for(TblVehiculo it: vehiculosLista){
            vehiculoFiltro = vehiculosLista.get(iterador);
            if(vehiculoFiltro.getVehPrecio() >= desde && vehiculoFiltro.getVehPrecio() <= hasta){
                vehiculos.add(vehiculoFiltro);
            }
            iterador++;
        }
        
        if(!vehiculos.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                                        "Filtro exitoso de " + desde + " a " + hasta,
                                        "Filtro exitoso de " + desde + " a " + hasta
                                ));
        }
        
        if(vehiculos.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "No hay autos en el rango de precios de " + desde + " a " + hasta,
                                        "No hay autos en el rango de precios de " + desde + " a " + hasta
                                ));
        }
        
        desde = 0;
        hasta = 0;
        
    }
    
    public TblVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(TblVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TblCategoria getCat() {
        return cat;
    }

    public void setCat(TblCategoria cat) {
        this.cat = cat;
    }

    public UsuarioSesion getUsuSesion() {
        return usuSesion;
    }

    public void setUsuSesion(UsuarioSesion usuSesion) {
        this.usuSesion = usuSesion;
    }

    public List<TblCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<TblCategoria> categorias) {
        this.categorias = categorias;
    }

    public List<TblVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<TblVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public TblVehiculo getVehiculoTemporal() {
        return vehiculoTemporal;
    }

    public void setVehiculoTemporal(TblVehiculo vehiculoTemporal) {
        this.vehiculoTemporal = vehiculoTemporal;
    }

    public Integer getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(Integer fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public TblDatospersonales getDatoPersonal() {
        return datoPersonal;
    }

    public void setDatoPersonal(TblDatospersonales datoPersonal) {
        this.datoPersonal = datoPersonal;
    }

    public TblVehiculo getVehiculoFiltro() {
        return vehiculoFiltro;
    }

    public void setVehiculoFiltro(TblVehiculo vehiculoFiltro) {
        this.vehiculoFiltro = vehiculoFiltro;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public List<TblVehiculo> getVehiculosLista() {
        return vehiculosLista;
    }

    public void setVehiculosLista(List<TblVehiculo> vehiculosLista) {
        this.vehiculosLista = vehiculosLista;
    }

    public List<TblVehiculo> getVehiculosFiltrados() {
        return vehiculosFiltrados;
    }

    public void setVehiculosFiltrados(List<TblVehiculo> vehiculosFiltrados) {
        this.vehiculosFiltrados = vehiculosFiltrados;
    }
          
}
