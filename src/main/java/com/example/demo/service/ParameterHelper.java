package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.exception.ParameterException;


@Component
public class ParameterHelper {

	public void validarCamposParameter(ParameterDto parameterDto, boolean validateId) throws ParameterException {

		if (parameterDto == null) {
			throw new ParameterException("ParametroDto no debe ser nulo.");
		} else if (validateId && parameterDto.getId() == null) {
			throw new ParameterException("El campo id es requerido.");
		} else if (parameterDto.getIdGroupParameter() == null) {
			throw new ParameterException("El campo idGroupParametro es requerido.");
		} else if (parameterDto.getName() == null) {
			throw new ParameterException("El campo name es requerido.");
		}

	}

	public void validarCamposGroupParameter(GroupParameterDto groupParameterDto, boolean validateId) throws ParameterException {

		if (groupParameterDto == null) {
			throw new ParameterException("GroupParameterDto no debe ser nulo.");
		} else if (validateId && groupParameterDto.getId() == null) {
			throw new ParameterException("El campo id es requerido.");
		} else if (groupParameterDto.getName() == null) {
			throw new ParameterException("El campo name es requerido.");
		} 

	}
	
	
	
	

}
