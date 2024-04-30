package com.example.taxa_tsp_demo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@ToString
@Data
public class TaxBill {
    @Id
    @GeneratedValue
    private int tbCode;
    @ManyToOne
    TaxPayer taxPayer;
    @OneToMany
     List <TaxPayingTransaction> taxPayingTransactions;

    public TaxBill(int tbCode, TaxPayer taxPayer, List<TaxPayingTransaction> taxPayingTransactions) {
        this.tbCode = tbCode;
        this.taxPayer = taxPayer;
        this.taxPayingTransactions = taxPayingTransactions;
    }

    public TaxBill() {

    }

    public List<TaxPayingTransaction> getTaxPayingTransactions() {
        return taxPayingTransactions;
    }
}
