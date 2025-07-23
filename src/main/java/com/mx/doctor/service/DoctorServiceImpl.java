package com.mx.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.doctor.model.Doctor;
import com.mx.doctor.repository.DoctorInterfaceRepository;

@Service
public class DoctorServiceImpl implements DoctorInterfaceService {

    @Autowired
    DoctorInterfaceRepository repository;

    @Override
    public Doctor crearDoctor(Doctor doctor) {
        Doctor result = null;
        try {
            result = repository.save(doctor);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Doctor buscarDoctor(Doctor doctor) {
        Doctor resultado = null;
        try {
            resultado = repository.findByNumeroDeCedula(doctor.getNumeroDeCedula());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public Doctor actualizarDoctor(Doctor doctor, int idDoctor) {
        Doctor guardar = new Doctor();
        try {
            boolean recuperado = repository.existsById(idDoctor);
            if (recuperado == true) {
                guardar.setIdDoctor(idDoctor);
                guardar.setNombre(doctor.getNombre());
                guardar.setTipoEspecialidad(doctor.getTipoEspecialidad());
                guardar.setNumeroDeCedula(doctor.getNumeroDeCedula());
                guardar.setTelefono(doctor.getTelefono());
                guardar.setCorreo(doctor.getCorreo());
                guardar = repository.save(guardar);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return guardar;
    }

    @Override
    public void eliminarDoctor(int idDoctor) {
        {
            int id = (int) idDoctor;
            try {
                repository.deleteById(id);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public Doctor  buscarNumeroDeCedula(int numeroDeCedula) {
        Doctor recuperado = null;
        try{
          recuperado = repository.findByNumeroDeCedula(numeroDeCedula);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  recuperado;
}

@Override 
    public boolean buscarPorId(int id){
            boolean recuperado = false; 
        try {
         recuperado = repository.existsById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  recuperado;
}



}

