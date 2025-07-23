package com.mx.doctor.service;

import com.mx.doctor.model.Doctor;

public interface DoctorInterfaceService {

    Doctor crearDoctor(Doctor doctor);

    Doctor buscarDoctor(Doctor doctor);

    Doctor actualizarDoctor(Doctor doctor, int idDoctor);

    void eliminarDoctor(int idDoctor);
    
    Doctor buscarNumeroDeCedula(int numeroDeCedula);

    boolean buscarPorId(int Id);

}
