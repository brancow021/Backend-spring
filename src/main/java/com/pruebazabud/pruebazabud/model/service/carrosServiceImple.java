package com.pruebazabud.pruebazabud.model.service;

import com.pruebazabud.pruebazabud.model.dao.iCarrosDao;
import com.pruebazabud.pruebazabud.models.entity.Carros;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class carrosServiceImple implements iCarrosService {
    
    
    @Autowired
    private iCarrosDao carrodao;

    @Override 
    @Transactional(readOnly = true)
    public List<Carros> findAll() {
        return (List<Carros>) carrodao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Carros FindById(Long id) {
        
        return carrodao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Carros save(Carros carros) {
        
        return carrodao.save(carros);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        carrodao.deleteById(id);
    }
    
}
