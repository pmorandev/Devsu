package com.pmoran.devsu.service.cliente.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pmoran.devsu.service.cliente.constant.GeneroEnum;
import jakarta.validation.constraints.*;

import com.pmoran.devsu.service.cliente.util.MessageUtility;

public class ClienteDTO extends BaseDTO {

    @Null
    private Long id;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_NOMBRE_EMPTY)
    @NotEmpty(message = MessageUtility.CLIENTE_MODEL_NOMBRE_EMPTY)
    private String nombre;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_IDENTIDAD_EMPTY)
    @NotEmpty(message = MessageUtility.CLIENTE_MODEL_IDENTIDAD_EMPTY)
    @Pattern(regexp = "^\\d{4}-\\d{4}-\\d{5}$", message = MessageUtility.CLIENTE_MODEL_IDENTIDAD_NOT_MATCH)
    private String identidad;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_GENERO_EMPTY)
    @JsonProperty("genero")
    private GeneroEnum genero;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_EDAD_EMPTY)
    @Min(value = 18L, message = MessageUtility.CLIENTE_MODEL_EDAD_MIN)
    private Integer edad;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_DIRECCION_EMPTY)
    @NotEmpty(message = MessageUtility.CLIENTE_MODEL_DIRECCION_EMPTY)
    private String direccion;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_TELEFONO_EMPTY)
    @NotEmpty(message = MessageUtility.CLIENTE_MODEL_TELEFONO_EMPTY)
    @Pattern(regexp = "^\\+\\d{10,}$", message = MessageUtility.CLIENTE_MODEL_TELEFONO_NOT_MATCH)
    private String telefono;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_ESTADO_EMPTY)
    private Boolean estado;

    @NotNull(message = MessageUtility.CLIENTE_MODEL_PASSWORD_EMPTY)
    @Size(min = 10, message = MessageUtility.CLIENTE_MODEL_PASSWORD_MIN)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$", message = MessageUtility.CLIENTE_MODEL_PASSWORD_NOT_MATCH)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
