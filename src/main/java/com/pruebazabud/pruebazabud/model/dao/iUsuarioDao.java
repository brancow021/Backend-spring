/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebazabud.pruebazabud.model.dao;

import com.pruebazabud.pruebazabud.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP
 */
public interface iUsuarioDao extends CrudRepository<Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.username=?1")
    public Usuario findByUsername2(String username);
    
    public Usuario findByUsername(String username);
    
}
