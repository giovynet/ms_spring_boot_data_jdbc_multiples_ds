package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.exception.DaoException;
import com.example.demo.exception.ParameterException;

public interface ParameterService {
	
	/**
	 * Update a groupParameterDto in datasource one.
	 * @param groupParameterDto
	 * @throws DaoException
	 */
	void updateGroupParameterDsOne(GroupParameterDto groupParameterDto) throws ParameterException;
	
	/**
	 * Create parameterDto with groupParameterDto in datasource one. 
	 * @param groupParameterDto
	 * @param parameterDao
	 * @throws DaoException
	 */
	void createGroupParameterWithParameterDsOne(GroupParameterDto groupParameterDto, ParameterDto parameterDto ) throws ParameterException;
		
	/**
	 * Create parameterDto with groupParameterDto in datasources one and two. 
	 * @param groupParameterDto
	 * @param parameterDao
	 * @throws DaoException
	 */
	void createGroupParameterWithParameterDsOneTwo(GroupParameterDto groupParameterDto, ParameterDto parameterDto ) throws ParameterException;
	
	/**
	 * Select list of all GroupParameter from datasource one.
	 * @return
	 * @throws DaoException
	 */
	List<GroupParameterDto> selectListGroupParameterDsOne()  throws ParameterException;
	
	/**
	 * Select list of all GroupParameter from datasource two.
	 * @return
	 * @throws DaoException
	 */
	List<GroupParameterDto> selectListGroupParameterDsTwo()  throws ParameterException;

	
}
