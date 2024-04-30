package com.example.taxa_tsp_demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaxPayerMapper {
    @Mapping(target = "tpID", source = "dto.tpId")
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "taxpayingCode", source = "dto.taxpayingCode")
    @Mapping(target = " taxBills", source = "dto. taxBills")
    TaxPayer taxPayerDTOtoTaxpayer(TaxPayerDTO dto);
}
