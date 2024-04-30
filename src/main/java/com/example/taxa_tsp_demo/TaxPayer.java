package com.example.taxa_tsp_demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
@Builder
@ToString
@AllArgsConstructor
@Data
public class TaxPayer {
    @Id
    @GeneratedValue
    private int tpID;
    private String name;
    private String taxpayingCode;
    @OneToMany
    List<TaxBill> taxBills;

    public TaxPayer() {
    }

    public List<TaxBill> getTaxBills() {
        return taxBills;
    }
}
