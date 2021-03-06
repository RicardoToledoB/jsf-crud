/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.model.Rol;
import com.proyecto.model.Usuario;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ricardotoledo
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void save(Usuario u) {
        
        em.persist(u);
    }

    @Override
    public void edit(Usuario u) {
        em.merge(u);
    }

    @Override
    public void delete(Usuario u) {
        em.remove(em.merge(u));
    }

    @Override
    public List<Usuario> list() {
        String sql = "select u from Usuario u ";
        Query query = em.createQuery(sql);
        List<Usuario> list= query.getResultList();
        return list;
    }

    @Override
    public Usuario find(Usuario u) {
        String sql = "select u from Usuario u WHERE u.id =" + u.getId();
        Query query = em.createQuery(sql);
        Usuario user= (Usuario) query.getSingleResult();
        return user;
    }
    
}
