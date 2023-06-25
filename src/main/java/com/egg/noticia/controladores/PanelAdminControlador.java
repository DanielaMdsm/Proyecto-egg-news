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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Daniela Tarea
 */
@Controller
@RequestMapping("/admin")
public class PanelAdminControlador { 
    @Autowired
    private NoticiaServicio noticiaServicio;
    
    @GetMapping("/")
    public String dashboard(){
        return "panel.html";
    }
    
    @GetMapping("/listarNoticias")
    public String listarNoticias(ModelMap modelo){
         List<Noticia> noticias= noticiaServicio.listaNoticia();
        modelo.addAttribute("noticias", noticias);
        return "admin-listar.html";
    }
    
    @GetMapping("/registrarNoticia")
    public String registrarNoticia(){return "admin-crear.html";}
    
    @PostMapping("/registrarNoticia")
    public String registro(@RequestParam String titulo,@RequestParam String cuerpo,@RequestParam String imgUrl,ModelMap modelo){
        try { 
            noticiaServicio.crearNoticia(titulo, cuerpo,imgUrl);
            modelo.put("exito","Noticia creada correctamente");
            return "redirect:admin/listarNoticias";
        } catch (Exception ex) {
             modelo.put("error",ex.getMessage());
             return "redirect:/registrarNoticia";
        }
       
    } 
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id,ModelMap modelo){ 
        modelo.put("noticia", noticiaServicio.getOne(id));
        return "admin-modificar.html";
        
    }
    
    @PostMapping("/modificar/{id}") 
    public String modificar(@PathVariable Long id, @RequestParam String titulo,@RequestParam String cuerpo,@RequestParam String imgUrl,ModelMap modelo) {
        try { 
            noticiaServicio.modificarNoticia(titulo, cuerpo,imgUrl, id);
            modelo.put("exito","la noticia se ha modificado correctamente");
            return "redirect:admin/listarNoticias";
        } catch (Exception ex) {
           modelo.put("error",ex.getMessage());
           return "admin-modificar.html";
        }
       
               
    } 
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,ModelMap modelo){
        noticiaServicio.eliminarNoticia(id);
        return "redirect:/admin/listarNoticias";
    } 
   
}
