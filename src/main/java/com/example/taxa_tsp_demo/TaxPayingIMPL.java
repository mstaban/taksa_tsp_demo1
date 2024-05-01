package com.example.taxa_tsp_demo;

import jakarta.annotation.Generated;
import org.mapstruct.MapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaxPayingIMPL implements TaxPayingService{

     TaxPayingMapper taxPayingMapper;
    @Autowired
    TaxPayerRepo tpRepo;
    @Autowired
    TaxBilRepo tbRepo;
    @Autowired
    TptRepo tptRepo;
    TaxPayerDTO taxPayerDTO;
    public synchronized void addTaxpayer(TaxPayerDTO taxPayerDTO) {

        TaxPayer taxPayer = taxPayingMapper.taxPayerDTOtoTaxpayer(taxPayerDTO);
        tpRepo.save(taxPayer);
    }

    @Override
    public synchronized void addTaxBill(TaxBillDTO taxBillDTO) {
        TaxBill taxBill =taxPayingMapper.taxBillDTOtoTaxBill(taxBillDTO);
        tbRepo.save(taxBill);
    }
    @Override
    public synchronized void addTPTransaction(TaxPayingTransactionDTO tptDTO) {
        TaxPayingTransaction tpTransaction = new TaxPayingTransaction.TaxPayingTransactionBuilder().transactionID(tptDTO.getTransactionID())
                .amount(tptDTO.getAmount()).taxBill(tptDTO.getTaxBill()).build();
        tptRepo.save(tpTransaction);
    }
    @Override
    public List<TaxPayer> getAllTaxPayers() {
      return tpRepo.findAll();
    }
    @Override
    public List<TaxBill> getAllTaxBillsOfATaxPayer(int id) {
         TaxPayer taxPayer = tpRepo.findById(id).get();
       return   taxPayer.getTaxBills();

    }

    @Override
    public List<TaxPayingTransaction> getAllTransactionsOfATaxBill(int tbCode) {
       TaxBill taxBill= tbRepo.findById(tbCode).get();
       return taxBill.getTaxPayingTransactions();
    }

    @Override
    public void updateTaxBill(TaxBillDTO taxBillDTO) {
        TaxBill taxBill = new TaxBill.TaxBillBuilder().taxPayingTransactions(taxBillDTO.getTaxPayingTransactions())
                .tbCode(taxBillDTO.getTbCode()).taxPayer(taxBillDTO.getTaxPayer()).build();
      tbRepo.save(taxBill);
    }






}
