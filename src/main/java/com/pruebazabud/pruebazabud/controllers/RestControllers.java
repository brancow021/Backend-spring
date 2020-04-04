
package com.pruebazabud.pruebazabud.controllers;

import com.pruebazabud.pruebazabud.model.service.iCarrosService;
import com.pruebazabud.pruebazabud.models.entity.Carros;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")
public class RestControllers {
    
    @Autowired
    private iCarrosService carroservice;
    
    
    @GetMapping("/carros")
    public List<Carros> index(){ //METODO QUE RETORNA EL RESULTADO DEL BUSCAR TODO LOS CARROS 
    
        return carroservice.findAll();
    }
    
    
    @GetMapping("/carros/{id}")
    public Carros show(@PathVariable Long id){
    
        return carroservice.FindById(id);
    }
    
    @PostMapping("/carros")
    @ResponseStatus(HttpStatus.CREATED)
    public Carros create(@RequestBody Carros carros){//METODO QUE GUARDA LOS DATOS INGRESADOS DESDE EL FRONTED EN LA BASE DE DATOS
      return carroservice.save(carros);
    }
    
    @PutMapping("/carros/{id}")
    public Carros update(@RequestBody Carros carro, @PathVariable Long id){//METODO QUE ACTUALIZA LOS DATOS DESDE UN ID
            
        Carros carroActual = carroservice.FindById(id);
        
        carroActual.setColor(carro.getColor());
        carroActual.setMarca(carro.getMarca());
        carroActual.setModelo(carro.getModelo());
        carroActual.setPlaca(carro.getPlaca());
        
        return carroservice.save(carroActual);
    }
    
    @DeleteMapping("/carros/{id}")
    public void delete(@PathVariable Long id){
    
       carroservice.delete(id);
    }
    
    
}
