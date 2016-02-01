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
import java.util.ArrayList;
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
    Usuario usuario;
    Usuario usuarioEdit;
    Usuario usuarioView;
    List<Usuario> lista;
    @Inject
    private RolServiceImpl rService;
    private List<Rol> roles;
    private List<Rol> rolesSelecionados;

    @PostConstruct
    public void init() {
        roles = rService.list();
        rolesSelecionados = new ArrayList<>();
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
        System.out.println("NOM" + usuario.getId());
        System.out.println("NOM" + usuario.getNombre());
        System.out.println("NOM" + usuario.getApepat());
        System.out.println("NOM" + usuario.getApemat());
        System.out.println("NOM" + usuario.getEstado());
        System.out.println("NOM" + usuario.getUsername());
        System.out.println("NOM" + usuario.getPassword());

        if (rolesSelecionados != null) {
            System.out.println("LLLLLLALALALALA");
        } else {
            System.out.println("MMMMMMM");
        }
        usuario.setRoles(rolesSelecionados);
        uService.save(usuario);
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
