package com.pmoran.devsu.service.cliente.util;

import org.springframework.stereotype.Component;

public class MessageUtility {

    public static final String RESOURCE_DUPLICATION_ERROR = "El recurso %s ya existe en el sistema";
    public static final String RESOURCE_NOT_FOUND = "El recurso con id %s no fue encontrado";
    public static final String CLIENTE_MODEL_NOMBRE_EMPTY = "Nombre del cliente no especificado";
    public static final String CLIENTE_MODEL_IDENTIDAD_EMPTY = "Identidad del cliente no especificada";
    public static final String CLIENTE_MODEL_GENERO_EMPTY = "Genero del cliente no especificado";
    public static final String CLIENTE_MODEL_GENERO_NOT_MATCH = "Genero del cliente no valido. Los valores soportados son: masculino, femenino, u otro";
    public static final String CLIENTE_MODEL_EDAD_EMPTY = "Edad del cliente no especificada";
    public static final String CLIENTE_MODEL_DIRECCION_EMPTY = "Direccion del cliente no especificada";
    public static final String CLIENTE_MODEL_TELEFONO_EMPTY = "Telefono del cliente no especificado";
    public static final String CLIENTE_MODEL_PASSWORD_EMPTY = "Password del cliente no especificado";
    public static final String CLIENTE_MODEL_ESTADO_EMPTY = "Estado del cliente no espcificado";
    public static final String CLIENTE_MODEL_IDENTIDAD_NOT_MATCH = "La identidad del cliente no es valida";
    public static final String CLIENTE_MODEL_TELEFONO_NOT_MATCH = "Telefono no valido";
    public static final String CLIENTE_MODEL_PASSWORD_NOT_MATCH = "El password debe contener al menos una mayuscula, un digito, y un caracter especial";
    public static final String CLIENTE_MODEL_EDAD_MIN = "El cliente debe tener mayoria de edad";
    public static final String CLIENTE_MODEL_PASSWORD_MIN = "El password debe contener al menos 10 caracteres";
}
