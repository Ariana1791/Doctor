package com.mx.doctor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name ="id_doctor")
    private int idDoctor;
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="tipo_especialidad")
    private String tipoEspecialidad;
    @Column(name ="numero_de_cedula")
    private int numeroDeCedula;
    @Column(name ="telefono")
    private long telefono;
    @Column(name ="correo")
    private String correo;

    public Doctor(){

    }

    public Doctor(int idDoctor, String nombre, String tipoEspecialidad, int numeroDeCedula, long telefono,
            String correo) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.tipoEspecialidad = tipoEspecialidad;
        this.numeroDeCedula = numeroDeCedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoEspecialidad() {
        return tipoEspecialidad;
    }

    public void setTipoEspecialidad(String tipoEspecialidad) {
        this.tipoEspecialidad = tipoEspecialidad;
    }

    public int getNumeroDeCedula() {
        return numeroDeCedula;
    }

    public void setNumeroDeCedula(int numeroDeCedula) {
        this.numeroDeCedula = numeroDeCedula;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
