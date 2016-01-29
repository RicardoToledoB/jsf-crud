/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.model.Rol;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ricardotoledo
 */
public class RolDAOImpl implements RolDAO{
    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Rol r) {
        em.persist(r);
    }

    @Override
    public void edit(Rol r) {
        em.merge(r);
    }

    @Override
    public void delete(Rol r) {
        em.remove(em.merge(r));
    }

    @Override
    public List<Rol> list() {
        String sql = "select r from Rol r ";
        Query query = em.createQuery(sql);
        List<Rol> list= query.getResultList();
        return list;
    }

    @Override
    public Rol find(Rol r) {
        String sql = "select r from Rol r WHERE r.id =" + r.getId();
        Query query = em.createQuery(sql);
        Rol rol= (Rol) query.getSingleResult();
        return rol;
    }

    @Override
    public Rol findById(Integer id) {
        String sql = "select r from Rol r WHERE r.id =" + id;
        Query query = em.createQuery(sql);
        Rol rol= (Rol) query.getSingleResult();
        return rol;
    }
    
}
