package com.example.taxa_tsp_demo;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

@Mapper
public interface TaxPayingMapper {
    @Mapping(target = "tpID", source = "dto.tpId")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "taxpayingCode", source = "dto.taxpayingCode")
    @Mapping(target = " taxBills", source = "dto. taxBills")
    TaxPayer taxPayerDTOtoTaxpayer(TaxPayerDTO dto);
    @Mapping(target = "tbCode", source = "dto.tpCode")
    @Mapping(target = "taxPayer", source = "dto.taxPayer")
    @Mapping(target = "taxpayingTransactions", source = "dto.taxpayingTransactions")
    TaxBill taxBillDTOtoTaxBill(TaxBillDTO dto);
    @Mapping(target = "transactionID", source = "dto.transactionID")
    @Mapping(target = "amount", source = "dto.amount")
    @Mapping(target = "taxBill", source = "dto.taxBill")
    TaxPayingTransaction taxpayingTransactionDTOtoTaxpayingTransaction(TaxBillDTO dto);
}
