package com.semanareact.myapp.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.semanareact.myapp.model.Sale;

public interface SmsRepository extends JpaRepository<Sale, Long> {

	@Query(value = "SELECT * FROM tb_sales WHERE date BETWEEN :min AND :max ORDER BY amount DESC", nativeQuery = true)
	public Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
}
