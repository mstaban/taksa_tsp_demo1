package com.example.taxa_tsp_demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@ToString
@AllArgsConstructor
@Data
public class TaxPayingTransaction {
    @Id
    @GeneratedValue
    private int transactionID;
    private double amount;
    @ManyToOne
    private TaxBill taxBill;
    public TaxPayingTransaction() {
    }
}
