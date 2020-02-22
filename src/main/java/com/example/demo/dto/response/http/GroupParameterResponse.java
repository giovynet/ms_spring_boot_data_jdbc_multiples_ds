package com.example.demo.dto.response.http;

import java.util.List;

import com.example.demo.dto.GroupParameterDto;

public class GroupParameterResponse extends HttpResponse {
	
	
	
	public GroupParameterResponse() {
		super();
	}

	public GroupParameterResponse(List<GroupParameterDto> list ) {
		super();
		this.list = list;
	}

	private List<GroupParameterDto> list;	

	public List<GroupParameterDto> getList() {
		return list;
	}

	public void setList(List<GroupParameterDto> list) {
		this.list = list;
	}	

}
