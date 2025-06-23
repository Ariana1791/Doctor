package com.mx.doctor.service;

import java.util.List;

import com.mx.doctor.model.Doctor;

public interface DoctorInterfaceService {

    Doctor crearDoctor(Doctor doctor);

    List<Doctor> buscarDoctor();

    Doctor actualizarDoctor(Doctor doctor, int idDoctor);

    void eliminarDoctor(int idDoctor);

}
