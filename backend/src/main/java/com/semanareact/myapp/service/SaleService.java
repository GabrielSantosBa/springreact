package com.semanareact.myapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.semanareact.myapp.model.Sale;
import com.semanareact.myapp.repository.SaleRepository;



@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
		
		LocalDate today = LocalDate.now();
		
		LocalDate dateMin = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
		
		LocalDate dateMax = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findSales(dateMin, dateMax, pageable);
	}
	
	
	
	
}
