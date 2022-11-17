package com.magacho.camp_gladiator_test.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<E> {

    private HttpStatus status;

    private String msg;

    private E payload;

    private List<String> errors;

    public Response() {
    }

    public Response(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(HttpStatus status, String msg, E payload) {
        this.status = status;
        this.msg = msg;
        this.payload = payload;
    }

    public Response(HttpStatus status, String msg, E payload, List<String> errors) {
        this.status = status;
        this.msg = msg;
        this.payload = payload;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getPayload() {
        return payload;
    }

    public void setPayload(E payload) {
        this.payload = payload;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "Response [status=" + status + ", msg=" + msg + ", payload=" + payload + "]";
    }
}