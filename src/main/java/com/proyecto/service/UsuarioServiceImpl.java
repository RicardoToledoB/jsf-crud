/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.service;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.dao.UsuarioDAOImpl;
import com.proyecto.model.Usuario;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
@LocalBean
@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    
    @Inject
    private UsuarioDAOImpl uDAO;
    @Override
    public void save(Usuario u) {
        uDAO.save(u);
    }

    @Override
    public void edit(Usuario u) {
        uDAO.edit(u);
    }

    @Override
    public void delete(Usuario u) {
        uDAO.delete(u);
    }

    @Override
    public List<Usuario> list() {
        return uDAO.list();
    }

    @Override
    public Usuario find(Usuario u) {
        return uDAO.find(u);
    }
    
}
