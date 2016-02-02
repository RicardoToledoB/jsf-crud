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
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    Usuario usuario;
    Usuario usuarioEdit;
    Usuario usuarioView;
    List<Usuario> lista;
    @Inject
    private RolServiceImpl rService;
    private List<Rol> roles;

    private List<String> rolesSeleccionados;

    @PostConstruct
    public void init() {
        roles = rService.list();

        usuario = new Usuario();
        usuarioEdit = new Usuario();
        usuarioView = new Usuario();
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
        usuarioEdit = new Usuario();
    }

    public void save() {
        System.out.println(rolesSeleccionados);
        
        List<Rol> rolSelected=new ArrayList<Rol>();
        for(String str:rolesSeleccionados){
           int rolid=Integer.parseInt(str);
           System.out.println("ID"+rolid);
           Rol r=rService.findById(rolid);
           System.out.println("ID:"+r.getId());
           System.out.println("ID:"+r.getTipo());
          // usuario.getRoles().add(r);
           rolSelected.add(r);
           
            
        }
        usuario.setRoles(rolSelected);
        uService.save(usuario);
        
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<String> getRolesSeleccionados() {
        return rolesSeleccionados;
    }

    public void setRolesSeleccionados(List<String> rolesSeleccionados) {
        this.rolesSeleccionados = rolesSeleccionados;
    }

}
