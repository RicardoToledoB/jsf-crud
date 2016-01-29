/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.service;

import com.proyecto.model.Rol;
import java.util.List;

/**
 *
 * @author ricardotoledo
 */
public interface RolService {
    public void save(Rol r);
    public void edit(Rol r);
    public void delete(Rol r);
    public List<Rol> list();
    public Rol find(Rol r);
    public Rol findById(Integer id);
}
