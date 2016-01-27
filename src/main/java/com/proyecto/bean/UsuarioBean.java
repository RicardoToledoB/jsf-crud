package com.proyecto.bean;

import com.proyecto.model.Usuario;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.UsuarioServiceImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
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
    }

    public void save(Usuario u) {
        uService.save(u);
        usuario = new Usuario();
    }
}
