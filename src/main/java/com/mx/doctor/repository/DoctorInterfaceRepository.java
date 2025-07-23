package com.mx.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.doctor.model.Doctor;

public interface DoctorInterfaceRepository extends JpaRepository<Doctor, Integer>{

    
 Doctor findByNumeroDeCedula(int  numeroDeCedula);
}
