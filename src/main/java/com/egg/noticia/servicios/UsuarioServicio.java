
package com.egg.noticia.servicios;

import com.egg.noticia.entidades.Usuario;
import com.egg.noticia.enums.Rol;
import com.egg.noticia.repositorios.UsuarioRepositorio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements UserDetailsService {  
    
    @Autowired
    private  UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrarUsuario(String email,String nombreUsuario,String password,String password2) throws Exception{
        validar(email,nombreUsuario,password,password2);
        Usuario usuario= new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setEmail(email);
        usuario.setFechaAlta(LocalDate.now());
        usuario.setRol(Rol.USER);
        usuario.setActivo(true);
        
        usuarioRepositorio.save(usuario);
    }
    
    public void validar(String email,String nombre,String password,String password2) throws Exception{
    
        if(email.isEmpty() || email==null){
            throw new Exception("Ingrese un email");
        } 
        if(nombre.isEmpty() || nombre==null){
            throw new Exception("Ingrese un nombre de usuario");
        } 
        if(password.isEmpty() || password==null || password.length()<=6){
            throw new Exception("La contraseña no puede estar vacia y tiene que tener mas de 6 digitos");
        } 
        if(!password.equals(password2)){
            throw new Exception("Ambas contraseñas deben ser iguales");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        
        Usuario usuario= usuarioRepositorio.buscarUsuario(nombre);
        
        if(usuario!=null){ 
            
            List<GrantedAuthority> permisos= new ArrayList();
            
            GrantedAuthority p= new SimpleGrantedAuthority("ROLE_"+ usuario.getRol().toString());
            
            permisos.add(p);
            
             return new User(usuario.getNombreUsuario(),usuario.getPassword(),permisos);
        }else{
            return null;
        }
   
    }    

}