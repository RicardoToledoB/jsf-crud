package com.proyecto.bean.administrador.usuario;

import com.proyecto.bean.administrador.rol.RolBean;
import com.proyecto.model.Rol;
import com.proyecto.model.Usuario;
import com.proyecto.service.RolServiceImpl;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.UsuarioServiceImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author ricardotoledo
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
    
    @Inject
    private UsuarioServiceImpl uService;
    Usuario usuario = new Usuario();
    Usuario usuarioEdit = new Usuario();
    Usuario usuarioView = new Usuario();
    List<Usuario> lista;
    @Inject 
    private RolServiceImpl rService;
    private List<Rol> roles;
    private List<Rol> rolesSelecionados;
    @PostConstruct
    public void Usuario(){
       roles=rService.list();
      
       
    }
    
    public UsuarioBean() {

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return lista = uService.list();
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public String setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = uService.find(usuarioEdit);
        return "edit?faces-redirect=true";
    }

    public Usuario getUsuarioView() {
        return usuarioView;

    }

    public String setUsuarioView(Usuario usuarioView) {
        this.usuarioView = uService.find(usuarioView);
        return "view?faces-redirect=true";
    }

    public void delete(Usuario u) {
        uService.delete(u);
    }

    public void edit(Usuario u) {
        uService.edit(u);
        usuarioEdit=new Usuario();
    }

    public void save(Usuario u) {
       
        u.setRoles(rolesSelecionados);
        uService.save(u);
        usuario = new Usuario();
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

   


    public List<Rol> getRolesSelecionados() {
        return rolesSelecionados;
    }

    public void setRolesSelecionados(List<Rol> rolesSelecionados) {
        this.rolesSelecionados = rolesSelecionados;
    }
    
}
