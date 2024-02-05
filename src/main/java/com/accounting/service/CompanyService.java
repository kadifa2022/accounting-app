package com.accounting.service;

import com.accounting.dto.CompanyDTO;


import java.util.List;

public interface CompanyService {

   List<CompanyDTO>  listAllCompanies();
   List<CompanyDTO> listAllCompaniesOrderByStatus();

   CompanyDTO createCompany(CompanyDTO companyDTO);

   void  save(CompanyDTO companyDTO);

   CompanyDTO updateCompany(Long id, CompanyDTO companyDTO);



  CompanyDTO activateDeactivateCompanyStatus(Long id);
}
