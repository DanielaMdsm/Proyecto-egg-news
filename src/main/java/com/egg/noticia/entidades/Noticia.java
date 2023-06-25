/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.noticia.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.lang.NonNull;


/**
 *
 * @author Daniela Tarea
 */
@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 
    @NonNull
    private String img;
    @NonNull
    private String titulo; 
    @Column(columnDefinition = "longtext")
    @NonNull
    private String cuerpo;
    
    @ManyToOne
    @JoinColumn(name="creador_id")
    private Periodista creador;

    public Noticia() {
    }

    public Noticia(Long id,String img, String titulo, String cuerpo) {
        this.id = id;
        this.img=img;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
    
    
    
}
