package com.pmoran.devsu.service.cuenta.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pmoran.devsu.service.cuenta.util.MessageUtility;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.Arrays;

public enum TipoCuentaEnum {
    AHORRO("ahorro"),
    CORRIENTE("corriente");

    private String value;

    TipoCuentaEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TipoCuentaEnum valueOfString(String value) {
        return Arrays.stream(values())
                .filter(v -> v.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new HttpMessageNotReadableException(MessageUtility.CUENTA_MODEL_TIPO_NOT_MATCH));
    }

    @Override
    public String toString(){
        return this.value;
    }

}
