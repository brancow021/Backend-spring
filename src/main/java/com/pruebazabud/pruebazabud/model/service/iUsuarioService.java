
package com.pruebazabud.pruebazabud.model.service;

import com.pruebazabud.pruebazabud.models.entity.Usuario;


public interface iUsuarioService {
    
    public Usuario findByUsername(String username);
}
