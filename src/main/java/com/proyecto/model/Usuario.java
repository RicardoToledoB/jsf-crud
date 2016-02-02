package com.proyecto.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apepat")
    private String apepat;
    @Column(name = "apemat")
    private String apemat;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "estado")
    private String estado;

    @ManyToMany
    @JoinTable(name = "Usuarios_Roles",
            joinColumns = {
                @JoinColumn(name = "usuario_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "rol_id")}
    )
    List<Rol> roles;

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    
    
    public Usuario() {
    }

    public Usuario(int id, String nombre, String apepat, String apemat, String estado, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apepat = apepat;
        this.apemat = apemat;
        this.estado = estado;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
