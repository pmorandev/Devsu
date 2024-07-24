package com.pmoran.devsu.service.cliente.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Personas")
public class Persona extends BaseEntity {
    @Id
    @Column(name = "Identidad", unique = true, nullable = false)
    private String identidad;

    @Column(name = "Nombre", nullable = false, length = 1000)
    private String nombre;

    @Column(name = "Genero", nullable = false, length = 50)
    private String genero;

    @Column(name = "Edad", nullable = false)
    private Integer edad;

    @Column(name = "Direccion", nullable = false, length = 4000)
    private String direccion;

    @Column(name = "Telefono", nullable = false, length = 20)
    private String telefono;

    @OneToOne(mappedBy = "data")
    private Cliente cliente;

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
