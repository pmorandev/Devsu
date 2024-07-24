package com.pmoran.devsu.service.cuenta.util;

public class MessageUtility {

    public static final String RESOURCE_DUPLICATION_ERROR = "El recurso %s ya existe en el sistema";
    public static final String RESOURCE_NOT_FOUND = "El recurso con id %s no fue encontrado";
    public static final String CUENTA_MODEL_CUENTA_NOT_MATCH = "El numero de cuenta no es correcto";
    public static final String CUENTA_MODEL_CUENTA_EMPTY = "Numero cuenta no espicificado";
    public static final String CUENTA_MODEL_CLIENTE_EMPTY = "Id de cliente no especificado";
    public static final String CUENTA_MODEL_CLIENTE_NOT_FOUND = "cliente con id %s no encontrado";
    public static final String CUENTA_MODEL_TIPO_EMPTY = "Tipo de cuenta no especificado";
    public static final String CUENTA_MODEL_TIPO_NOT_MATCH = "Tipo de cuenta no valido. Los valores soportados son: ahorro o corriente";
    public static final String CUENTA_MODEL_ESTADO_EMPTY = "Estado de la cuenta no especificado";
    public static final String CUENTA_MODEL_SALDO_INICIAL_EMPTY = "Saldo inicial de la cuenta no especificado";
    public static final String CUENTA_MODEL_SALDO_INICIAL_NOT_MATCH = "El valor del saldo inicial debe ser mayor o igual a 0";
    public static final String MOVIMIENTO_MODEL_VALOR_EMPTY = "Monto del movimiento no especificado";
    public static final String MOVIMIENTO_MODEL_VALOR_ZERO = "El monto del movimiento no puede ser 0";
    public static final String MOVIMIENTO_VALOR_FAILED_TRANSACTION = "Saldo no disponible";
}
