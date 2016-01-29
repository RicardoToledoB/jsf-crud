/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.service;

import com.proyecto.dao.RolDAO;
import com.proyecto.model.Rol;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ricardotoledo
 */
@LocalBean
@Stateless
public class RolServiceImpl implements RolService{
    @Inject
    private RolDAO rDAO;
    @Override
    public void save(Rol r) {
        rDAO.save(r);
    }

    @Override
    public void edit(Rol r) {
        rDAO.edit(r);
    }

    @Override
    public void delete(Rol r) {
        rDAO.delete(r);
    }

    @Override
    public List<Rol> list() {
        return rDAO.list();
    }

    @Override
    public Rol find(Rol r) {
        return rDAO.find(r);
    }

    @Override
    public Rol findById(Integer id) {
        return rDAO.findById(id);
    }
    
}
