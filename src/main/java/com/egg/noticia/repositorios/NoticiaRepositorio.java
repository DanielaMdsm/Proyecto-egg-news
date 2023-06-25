/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.noticia.repositorios;

import com.egg.noticia.entidades.Noticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela Tarea
 */
@Repository
public interface NoticiaRepositorio  extends JpaRepository<Noticia,Long>{
    
  @Query("SELECT n FROM Noticia n WHERE n.titulo= :titulo")
    public Noticia buscarTitulo(@Param("titulo")  String titulo);
    @Query("SELECT n FROM Noticia n ORDER BY n.id DESC")
    public List<Noticia> buscarid();
    
}
