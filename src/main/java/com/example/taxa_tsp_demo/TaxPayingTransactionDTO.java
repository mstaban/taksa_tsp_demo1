package com.example.taxa_tsp_demo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaxPayingTransactionDTO {
    private int transactionID;
    private double amount;
    private TaxBill taxBill;
}
