/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.noticia.entidades;

import com.egg.noticia.enums.Rol;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

/**
 *
 * @author Daniela Tarea
 */ 
@Entity
public class Usuario implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String nombreUsuario;
    @NonNull
    private String password;
    @NonNull
    private LocalDate fechaAlta;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Rol rol;
    @NonNull
    private Boolean activo;

    public Usuario(Long id, String email, String nombreUsuario, String password, LocalDate fechaAlta, Rol rol, Boolean activo) {
        this.id = id;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.fechaAlta = fechaAlta;
        this.rol = rol;
        this.activo = activo;
    }

    public Usuario() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
    
           
}
