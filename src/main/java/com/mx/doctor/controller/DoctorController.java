package com.mx.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.doctor.model.Doctor;
import com.mx.doctor.service.DoctorInterfaceService;


@RestController
public class DoctorController {

    @Autowired
    DoctorInterfaceService service;

    @PostMapping(value ="/crearDoctor")
    public Doctor crearDoctor(@RequestBody Doctor doctor) {
       Doctor crear = null;
         try {
            crear = service.crearDoctor(doctor);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        
        return crear;
    }
    

    @GetMapping(value = "/buscarDoctor")
    public List <Doctor> buscarDoctor() {
       List <Doctor> buscar = null;
        try {
            buscar = service.buscarDoctor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return buscar;
    }


    @PutMapping(value = "/actualizarDoctor/{idDoctor}")
    public Doctor actualizarDoctor(@RequestBody Doctor doctor, @PathVariable int idDoctor) {
        Doctor actualizar = null;
        try {
            actualizar = service.actualizarDoctor(doctor, idDoctor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return actualizar;
    }


    @DeleteMapping(value = "/eliminarDoctor/{idDoctor}")
    public void eliminarDoctor(@PathVariable int idDoctor) {

        try {
            service.eliminarDoctor(idDoctor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
