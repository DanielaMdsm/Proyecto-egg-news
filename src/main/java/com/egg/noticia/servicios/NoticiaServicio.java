/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.noticia.servicios;

import com.egg.noticia.entidades.Noticia;
import com.egg.noticia.repositorios.NoticiaRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniela Tarea
 */ 
@Service
public class NoticiaServicio {
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;
    
    @Transactional
    public void crearNoticia (String titulo,String cuerpo,String img) throws Exception{
        validar(titulo,cuerpo,img);
        Noticia noticia= new Noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticia.setImg(img);
        noticiaRepositorio.save(noticia);
        
    }
    
    public List<Noticia> listaNoticia(){
        return  noticiaRepositorio.buscarid();
    }
    
    public void eliminarNoticia(Long id){
        noticiaRepositorio.deleteById(id);
    
    }    
    
    @Transactional
    public void modificarNoticia(String titulo,String cuerpo,String img,Long id) throws Exception{
       
        validar(titulo,cuerpo,img);
        
        Optional<Noticia> respuesta= noticiaRepositorio.findById(id);
        
        if(respuesta.isPresent()){
            
            Noticia noticia= respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setImg(img);
            noticiaRepositorio.save(noticia);
            
        }
        
        
    } 
    public Noticia getOne(Long id){
        return noticiaRepositorio.getOne(id);
    }
    
    private void validar(String titulo,String cuerpo,String img) throws Exception{
        
        if(img.isEmpty() || img==null){
            throw new Exception ("imagen vacia");
        }
        if(titulo.isEmpty() || titulo==null){
            throw new Exception ("Titulo vacio o nulo");
            
        }
        if(cuerpo.isEmpty() || cuerpo==null){
            throw new Exception("el cuerpo de la noticia no puede estar vacio");
        }
    }
}
