package com.egg.noticia.controladores;

import com.egg.noticia.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    
    @GetMapping("/login")
    public String login(@RequestParam (required=false) String error,ModelMap modelo) { 
        if(error !=null){
            modelo.put("error", "Usuario o contraseña invalidos");
        }
        return "form-login.html";
    }

  

    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {
        return "login-registro.html";
    }

    @PostMapping("/registro")
    public String registro(ModelMap modelo, @RequestParam String email, @RequestParam String nombreUsuario, @RequestParam String password, @RequestParam String password2) {
       
        try {
            usuarioServicio.registrarUsuario(email, nombreUsuario, password, password2);
            modelo.put("exito", "Usuario registrado correctamente");
            return "redirect:/";
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage()); 
            modelo.put("nombreUsuario",nombreUsuario);
            modelo.put("email",email);
            return "login-registro.html";
        }
    }
}
