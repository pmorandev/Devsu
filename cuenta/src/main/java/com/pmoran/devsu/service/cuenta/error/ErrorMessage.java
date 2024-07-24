package com.pmoran.devsu.service.cuenta.error;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public class ErrorMessage implements Serializable {

    private Integer code;

    private HttpStatus status;

    private List<String> errors;

    public ErrorMessage() {}

    public ErrorMessage(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
        this.code = status.value();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

}
