package com.example.taxa_tsp_demo;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaxPayerDTO {
    private int tpID;
    private String name;
    private String taxpayingCode;
    List<TaxBill> taxBills;
}
