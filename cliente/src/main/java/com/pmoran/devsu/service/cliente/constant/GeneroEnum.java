package com.pmoran.devsu.service.cliente.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pmoran.devsu.service.cliente.util.MessageUtility;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.Arrays;

public enum GeneroEnum {

    MASCULINO("masculino"),
    FEMENINO("femenino"),
    OTRO("otro");

    private String genero;

    GeneroEnum(String genero) {
        this.genero = genero;
    }

    @JsonValue
    public String getValue() {
        return genero;
    }

    @JsonCreator
    public static GeneroEnum valueOfString(String value) {
        return Arrays.stream(values())
                .filter(v -> v.genero.equals(value))
                .findFirst()
                .orElseThrow(() -> new HttpMessageNotReadableException(MessageUtility.CLIENTE_MODEL_GENERO_NOT_MATCH));
    }

    @Override
    public String toString(){
        return this.genero;
    }

}
