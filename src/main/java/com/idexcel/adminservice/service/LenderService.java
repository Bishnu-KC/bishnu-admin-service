package com.idexcel.adminservice.service;

import java.util.List;

import com.idexcel.adminservice.entity.Lender;

public interface LenderService {
	
	String create(Lender lender);
	List<Lender> findAll();
	Lender findById(String id);
	Lender updateById(String id);
	void update(String id, Lender lender);
	void delete(String id);

}
