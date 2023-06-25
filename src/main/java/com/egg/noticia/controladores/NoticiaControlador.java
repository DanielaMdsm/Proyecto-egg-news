/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.noticia.controladores;

import com.egg.noticia.entidades.Noticia;
import com.egg.noticia.servicios.NoticiaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Daniela Tarea
 */ 
@Controller
@RequestMapping("/")
public class NoticiaControlador {
    @Autowired
    private NoticiaServicio noticiaServicio;
    @GetMapping("/")
   public String inicio(){
       return "index1.html";
   } 
   @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_PERIODISTA')")
    @GetMapping("/index")
    public String index(ModelMap modelo) {
        List<Noticia> noticias= noticiaServicio.listaNoticia();
        modelo.addAttribute("noticias", noticias);
        return "index.html";
    }
    
     @GetMapping("/mostrar/{id}")
    public String mostrar(@PathVariable Long id,ModelMap modelo){
        Noticia noticia=noticiaServicio.getOne(id);
        modelo.addAttribute("noticia", noticia);
        return "mostrar.html";
    }
    
    
}
