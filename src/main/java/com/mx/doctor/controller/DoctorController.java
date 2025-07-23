package com.mx.doctor.controller;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.doctor.model.Doctor;
import com.mx.doctor.service.DoctorInterfaceService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class DoctorController {

    @Autowired
    DoctorInterfaceService service;

    @PostMapping(value ="/crearDoctor")
    public ResponseEntity <?> crearDoctor(@RequestBody Doctor doctor) {
       Doctor recuperado = service.buscarNumeroDeCedula(doctor.getNumeroDeCedula());
         if(recuperado == null){
            service.crearDoctor(doctor);
                return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el doctor se a guardado correctamente"));
        }
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","el doctor ya se encuentra registrado"));
    }

    @PostMapping(value = "/buscarDoctor")
    public ResponseEntity<?> buscarDoctor(@RequestBody Doctor doctor) {
        Doctor buscar = service.buscarNumeroDeCedula(doctor.getNumeroDeCedula());
        if(buscar != null){
            return ResponseEntity.status(HttpStatus.OK).body(buscar);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","servicio no encontrado"));
       
    }


    @PutMapping(value = "/actualizarDoctor/{idDoctor}")
    public ResponseEntity<?> actualizarDoctor(@RequestBody Doctor doctor, @PathVariable int idDoctor) {
        boolean recuperado = service.buscarPorId(idDoctor);
        if(recuperado == true){
            service.actualizarDoctor(doctor, idDoctor);
        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el Doctor se a actualizado correctamente"));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","idDoctor no encontrado"));
        
    }   
       


    @DeleteMapping(value = "/eliminarDoctor/{idDoctor}")
    public ResponseEntity<?> eliminarDoctor(@PathVariable int idDoctor) {
        boolean recuperado = service.buscarPorId(idDoctor);
        if(recuperado == true){
            service.eliminarDoctor(idDoctor);
         return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito","el idDoctor se a eliminado correctamente"));
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","Id no encontrado"));
    }
    


}    
