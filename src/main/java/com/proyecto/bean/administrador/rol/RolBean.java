/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.bean.administrador.rol;

import com.proyecto.model.Rol;
import com.proyecto.service.RolService;
import com.proyecto.service.RolServiceImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ricardotoledo
 */
@Named(value = "rolBean")
@SessionScoped
public class RolBean implements Serializable {
    @Inject
    private RolServiceImpl rService;
    Rol rol = new Rol();
    Rol rolEdit = new Rol();
    Rol rolView = new Rol();
    List<Rol> lista;
    List<Rol> selectedRol;

    public RolBean() {

    }

    public Rol getRol() {
        return rol;
    }

    public void setUsuario(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getLista() {
        return lista = rService.list();
    }

    public void setLista(List<Rol> lista) {
        this.lista = lista;
    }

    public Rol getRolEdit() {
        return rolEdit;
    }

    public String setRolEdit(Rol rolEdit) {
        this.rolEdit = rService.find(rolEdit);
        return "edit?faces-redirect=true";
    }

    public Rol getRolView() {
        return rolView;

    }

    public String setRolView(Rol rolView) {
        this.rolView = rService.find(rolView);
        return "view?faces-redirect=true";
    }

    public void delete(Rol r) {
        rService.delete(r);
    }

    public void edit(Rol r) {
        rService.edit(r);
        rolEdit=new Rol();
    }

    public void save(Rol r) {
        rService.save(r);
        rol = new Rol();
    }

    public List<Rol> getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(List<Rol> selectedRol) {
        this.selectedRol = selectedRol;
    }
    
}
