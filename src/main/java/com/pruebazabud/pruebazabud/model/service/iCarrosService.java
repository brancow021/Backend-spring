
package com.pruebazabud.pruebazabud.model.service;

import com.pruebazabud.pruebazabud.models.entity.Carros;
import java.util.List;


public interface iCarrosService  {
    
    public List<Carros> findAll();
    
    public Carros FindById(Long id);
    
    public Carros save (Carros carros);
    
    public void delete (Long id);
}
