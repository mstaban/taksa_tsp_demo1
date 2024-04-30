package com.example.taxa_tsp_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaxPayerRepo extends JpaRepository<TaxPayer, Integer> {
}
