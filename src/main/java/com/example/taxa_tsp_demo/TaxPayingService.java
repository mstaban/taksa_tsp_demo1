package com.example.taxa_tsp_demo;

import java.util.List;

public interface TaxPayingService {
    void addTaxpayer(TaxPayerDTO taxPayerDTO);

    void addTaxBill(TaxBillDTO taxBillDTO);

    void addTPTransaction(TaxPayingTransactionDTO tpDTO);

    List<TaxPayer> getAllTaxPayers();

    List<TaxBill> getAllTaxBillsOfATaxPayer(int id);

    List<TaxPayingTransaction> getAllTransactionsOfATaxBill(int tbCode);

    void updateTaxBill(TaxBillDTO taxBillDTO);
}
