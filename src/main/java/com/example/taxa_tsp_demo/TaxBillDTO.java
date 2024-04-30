package com.example.taxa_tsp_demo;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaxBillDTO {
    private int tbCode;
    TaxPayer taxPayer;
    List<TaxPayingTransaction> taxPayingTransactions;
}
