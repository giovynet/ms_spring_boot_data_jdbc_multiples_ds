package com.example.demo.dto;

public class ParameterDto {

	private Long id;
	private Long idGroupParameter;
	private String name;
	
	
	public ParameterDto() {
		super();
	}

	public ParameterDto(Long id, Long idGroupParameter, String name) {
		super();
		this.id = id;
		this.idGroupParameter = idGroupParameter;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdGroupParameter() {
		return idGroupParameter;
	}
	public void setIdGroupParameter(Long idGroupParameter) {
		this.idGroupParameter = idGroupParameter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ParameterDto [id=" + id + ", idGroupParameter=" + idGroupParameter + ", name=" + name + "]";
	}

	
}
