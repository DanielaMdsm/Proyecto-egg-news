
package com.egg.noticia.entidades;

import com.egg.noticia.enums.Rol;
import java.time.LocalDate;
import javax.persistence.Entity;



@Entity
public class Periodista extends Usuario {
   
    protected Integer sueldoMensual;

    public Periodista() {
    }

    
    public Periodista(Long id, String email, String nombreUsuario, String password, LocalDate fechaAlta, Rol rol, Boolean activo) {
        super(id, email, nombreUsuario, password, fechaAlta, rol, activo);
        this.sueldoMensual=sueldoMensual;
    }

    

    
    
    
}
