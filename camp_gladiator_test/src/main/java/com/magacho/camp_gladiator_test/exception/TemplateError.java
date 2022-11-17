package com.magacho.camp_gladiator_test.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timestamp;
	private List<String> errors;
	
	public TemplateError() {
		super();
	}
	
	public TemplateError(Integer status, String msg, Long timestamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timestamp = timestamp;
	}

	public TemplateError(Integer status, String msg, Long timestamp, List<String> errors) {
		super();
		this.status = status;
		this.msg = msg;
		this.timestamp = timestamp;
		this.errors = errors;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrors() {
		return errors;
	}
}