/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.noticia.entidades;

import com.egg.noticia.enums.Rol;
import java.time.LocalDate;
import javax.persistence.Entity;

/**
 *
 * @author Daniela Tarea
 */
@Entity
public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(Long id, String email, String nombreUsuario, String password, LocalDate fechaAlta, Rol rol, Boolean activo) {
        super(id, email, nombreUsuario, password, fechaAlta, rol, activo);
        
    }

   
   
    
    
}
