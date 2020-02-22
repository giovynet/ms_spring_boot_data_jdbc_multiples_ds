package com.example.demo.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.dto.response.http.GroupParameterResponse;
import com.example.demo.dto.response.http.HttpResponse;
import com.example.demo.exception.ParameterException;
import com.example.demo.service.ParameterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ParameterController {

	@Autowired
	private ParameterService parameterService;

	@GetMapping("/update/dsone/groupParameter")
	public HttpResponse updateGroupDsOne(@RequestParam(value = "groupParameter") String groupParamter) {
		HttpResponse httpResponse = null;
		try {			
			httpResponse = new HttpResponse( 
					HttpStatus.OK.toString(),
					HttpStatus.OK.name(), 
					HttpStatus.OK.value(), 
					"", 
					ZonedDateTime.now());			
			
			if (groupParamter != null) {
				GroupParameterDto groupParamterDto = new ObjectMapper().readValue(groupParamter,
						GroupParameterDto.class);
				System.out.println(groupParamterDto);
				parameterService.updateGroupParameterDsOne(groupParamterDto);
			}
		} catch (ParameterException e) {
			httpResponse = new HttpResponse( 
					e.getMessage(),
					HttpStatus.BAD_REQUEST.name(), 
					HttpStatus.BAD_REQUEST.value(), 
					"", 
					ZonedDateTime.now());			
			System.out.println("Service exception...... " + e.getMessage());
		} catch (Exception e) {
			httpResponse = new HttpResponse( 
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR.name(), 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), 
					"", 
					ZonedDateTime.now());			
		}
		return httpResponse;
	}

	@GetMapping("/create/dsone/groupParameterWithParameter")
	public HttpResponse crearGrupoParametroDsOne(@RequestParam(value = "groupParameter") String groupParameter,
			@RequestParam(value = "parameter") String parameter) {
		HttpResponse httpResponse = null;
		try {
			GroupParameterDto groupParameterDto = new ObjectMapper().readValue(groupParameter, GroupParameterDto.class);
			ParameterDto parameterDto = new ObjectMapper().readValue(parameter, ParameterDto.class);

			System.out.println(groupParameter);
			System.out.println(parameter);

			httpResponse = new HttpResponse( 
					HttpStatus.OK.toString(),
					HttpStatus.OK.name(), 
					HttpStatus.OK.value(), 
					"", 
					ZonedDateTime.now());			
			
			parameterService.createGroupParameterWithParameterDsOne(groupParameterDto, parameterDto);
		} catch (ParameterException e) {
			System.out.println("Service exception... " + e.getMessage());
			httpResponse = new HttpResponse( 
					e.getMessage(),
					HttpStatus.BAD_REQUEST.name(), 
					HttpStatus.BAD_REQUEST.value(), 
					"", 
					ZonedDateTime.now());	
		} catch (Exception e) {
			httpResponse = new HttpResponse( 
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR.name(), 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), 
					"", 
					ZonedDateTime.now());	
			e.printStackTrace();			
		}
		
		return httpResponse;
	}

	@GetMapping("/create/dsonetwo/groupParameterWithParameter")
	public HttpResponse crearGrupoParametroDsOneTwo(@RequestParam(value = "groupParameter") String groupParameter,
			@RequestParam(value = "parameter") String parameter) {
		HttpResponse httpResponse = null;
		
		try {
			GroupParameterDto groupParameterDto = new ObjectMapper().readValue(groupParameter, GroupParameterDto.class);
			ParameterDto parameterDto = new ObjectMapper().readValue(parameter, ParameterDto.class);

			System.out.println(groupParameter);
			System.out.println(parameter);

			parameterService.createGroupParameterWithParameterDsOneTwo(groupParameterDto, parameterDto);
			
			httpResponse = new HttpResponse( 
					HttpStatus.OK.toString(),
					HttpStatus.OK.name(), 
					HttpStatus.OK.value(), 
					"", 
					ZonedDateTime.now());			
			
		} catch (ParameterException e) {
			httpResponse = new HttpResponse( 
					e.getMessage(),
					HttpStatus.BAD_REQUEST.name(), 
					HttpStatus.BAD_REQUEST.value(), 
					"", 
					ZonedDateTime.now());	
			System.out.println("Service exception... " + e.getMessage());
		} catch (Exception e) {
			httpResponse = new HttpResponse( 
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR.name(), 
					HttpStatus.INTERNAL_SERVER_ERROR.value(), 
					"", 
					ZonedDateTime.now());	
			e.printStackTrace();
		}
		
		return httpResponse;
	}

	@GetMapping("/get/dsone/groupParameter")
	public GroupParameterResponse getListGroupParameterDsOne() {
		GroupParameterResponse response = null;
		try {
			List<GroupParameterDto> lst = parameterService.selectListGroupParameterDsOne();
			
			response = new GroupParameterResponse(lst);			
			response.setMessage(HttpStatus.OK.toString()); 
			response.setStatus(HttpStatus.OK.name());		
			response.setStatusCode(HttpStatus.OK.value());
			response.setDateTransaction(ZonedDateTime.now());
		
		} catch (ParameterException e) {
			response = new GroupParameterResponse();			
			response.setMessage(e.getMessage()); 
			response.setStatus(HttpStatus.BAD_REQUEST.name());		
			response.setStatusCode(HttpStatus.BAD_REQUEST.value());
			response.setDateTransaction(ZonedDateTime.now());

			System.out.println("Service exception... " + e.getMessage());
		} catch (Exception e) {
			response = new GroupParameterResponse();			
			response.setMessage(e.getMessage()); 
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());		
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDateTransaction(ZonedDateTime.now());
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/get/dstwo/groupParameter")
	public GroupParameterResponse getListGroupParameterDsTwo() {
		GroupParameterResponse response = null;
		try {
			List<GroupParameterDto> lst = parameterService.selectListGroupParameterDsTwo();
			
			response = new GroupParameterResponse(lst);			
			response.setMessage(HttpStatus.OK.toString()); 
			response.setStatus(HttpStatus.OK.name());		
			response.setStatusCode(HttpStatus.OK.value());
			response.setDateTransaction(ZonedDateTime.now());
		} catch (ParameterException e) {
			response = new GroupParameterResponse();			
			response.setMessage(e.getMessage()); 
			response.setStatus(HttpStatus.BAD_REQUEST.name());		
			response.setStatusCode(HttpStatus.BAD_REQUEST.value());
			response.setDateTransaction(ZonedDateTime.now());

			System.out.println("Service exception... " + e.getMessage());
		} catch (Exception e) {
			response = new GroupParameterResponse();			
			response.setMessage(e.getMessage()); 
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());		
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setDateTransaction(ZonedDateTime.now());
			e.printStackTrace();
		}
		return response;
	}

}