package com.example.taxa_tsp_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaxPayingIMPL implements TaxPayingService, TaxPayerMapper {
    TaxPayerMapper taxPayerMapper;
    @Autowired
    TaxPayerRepo tpRepo;
    @Autowired
    TaxBilRepo tbRepo;
    @Autowired
    TptRepo tptRepo;
    public void addTaxpayer(TaxPayerDTO taxPayerDTO) {
        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().taxBills(taxPayerDTO.getTaxBills()).name(taxPayerDTO
                .getName()).taxpayingCode(taxPayerDTO.getTaxpayingCode()).build();
        tpRepo.save(taxPayer);
    }
    @Override
    public void addTaxBill(TaxBillDTO taxBillDTO) {
        TaxBill taxBill = new TaxBill.TaxBillBuilder().taxPayingTransactions(taxBillDTO.getTaxPayingTransactions())
                .tbCode(taxBillDTO.getTbCode()).taxPayer(taxBillDTO.getTaxPayer()).build();
        tbRepo.save(taxBill);
    }
    @Override
    public void addTPTransaction(TaxPayingTransactionDTO tptDTO) {
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

    @Override
    public TaxPayer taxPayerDTOtoTaxpayer(TaxPayerDTO dto) {
        return taxPayerMapper.taxPayerDTOtoTaxpayer(dto);
    }
}
