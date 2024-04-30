package com.example.taxa_tsp_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxPayerController {
    @Autowired
    TaxPayingService taxPayingService;
    @PostMapping ("/taxpayer")
    public TaxPayerDTO addTaxPayer(@ModelAttribute TaxPayerDTO taxPayerDTO){
        taxPayingService.addTaxpayer(taxPayerDTO);
        return taxPayerDTO;
    }
    @PostMapping ("/taxpayer/taxbill")
    public TaxBillDTO addTaxBill(@ModelAttribute TaxBillDTO taxBillDTO){
        taxPayingService.addTaxBill(taxBillDTO);
        return taxBillDTO;
    }
    @PostMapping("/taxpayer/taxbill/tptransaction")
    public TaxPayingTransactionDTO addTPTransaction(@ModelAttribute TaxPayingTransactionDTO tpDTO){

        taxPayingService.addTPTransaction(tpDTO);
        return tpDTO;
    }
    @GetMapping("/taxpayers")
    public List<TaxPayer> getAllTaxPayers(){
         return taxPayingService.getAllTaxPayers();

    }
    @GetMapping ("/taxpayer/taxbills/{tpID}")
    public List<TaxBill> getAllTaxBillsOfATaxPayer(@PathVariable ("tpID") int tpID){
      return taxPayingService.getAllTaxBillsOfATaxPayer(tpID);
    }
    @GetMapping("/taxpayer/taxbill/tptransactions/{tbCode}")
    public List<TaxPayingTransaction> getAllTransactionsOfATaxBill(@PathVariable ("tbCode") int tbCode){
        return taxPayingService.getAllTransactionsOfATaxBill(tbCode);
    }
    @PutMapping("/taxpayer/taxbill/update")
    public TaxBillDTO updateTaxBill(@ModelAttribute TaxBillDTO taxBillDTO){
        taxPayingService.updateTaxBill(taxBillDTO);
        return taxBillDTO;
    }



}
