package com.accounting.service.impl;

import com.accounting.dto.AddressDTO;
import com.accounting.dto.CompanyDTO;

import com.accounting.entity.Address;
import com.accounting.entity.Company;
import com.accounting.enums.CompanyStatus;
import com.accounting.mapper.MapperUtil;
import com.accounting.repository.CompanyRepository;
import com.accounting.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;


    private final MapperUtil mapperUtil;


    public CompanyServiceImpl(CompanyRepository companyRepository, MapperUtil mapperUtil) {
        this.companyRepository = companyRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<CompanyDTO> listAllCompanies() {
        List<Company> list = companyRepository.findAll();
        return list.stream().map(company -> mapperUtil.convert(company, new CompanyDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CompanyDTO> listAllCompaniesOrderByStatus() {
        List<CompanyDTO> list = companyRepository.findAllOrderByCompanyStatus(CompanyStatus.ACTIVE)
                .stream().filter(company -> company.getId() != 1)
                .map(company -> mapperUtil.convert(company, new CompanyDTO()))
                .collect(Collectors.toList());
        return list;

    }

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = companyRepository.save(mapperUtil.convert(companyDTO, new Company()));
        return mapperUtil.convert(company, new CompanyDTO());
    }


    @Override
    public void save(CompanyDTO companyDTO) {
        companyDTO.setCompanyStatus(CompanyStatus.PASSIVE);
        Company company = mapperUtil.convert(companyDTO, new Company());
        companyRepository.save(company);


    }

    @Override
    public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
        //find company from db if is available
       Company company = companyRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Company could not be found" + id));
       company.setCompanyStatus(companyDTO.getCompanyStatus());
       company.setPhone(companyDTO.getPhone());
       company.setTitle(companyDTO.getTitle());
       company.setWebsite(companyDTO.getWebsite());
      // company.setId(companyDTO.getId());

       //Update the fields from the Address
        AddressDTO updatedAddressDTO = companyDTO.getAddress();
        if(updatedAddressDTO != null){
            Address address = company.getAddress();

            address.setAddressLine1(updatedAddressDTO.getAddressLine1());
            address.setAddressLine2(updatedAddressDTO.getAddressLine2());
            address.setCity(updatedAddressDTO.getCity());
            address.setState(updatedAddressDTO.getState());
            address.setCountry(updatedAddressDTO.getCountry());
            address.setZipCode(updatedAddressDTO.getZipCode());
         //   address.setId(updatedAddressDTO.getId());
        }
        Company updatedCompany = companyRepository.save(company);
        return mapperUtil.convert(updatedCompany, new CompanyDTO());


    }

    @Override
    public CompanyDTO activateDeactivateCompanyStatus(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Company could not be found" + id));
        getCompanyStatus(company);
        Company updatedCompany = companyRepository.save(company);
        return mapperUtil.convert(updatedCompany, new CompanyDTO());
    }

    private void getCompanyStatus(Company company) {
        if(company.getCompanyStatus() == CompanyStatus.PASSIVE){
            company.setCompanyStatus(CompanyStatus.ACTIVE);
        }else{
            company.setCompanyStatus(CompanyStatus.PASSIVE);
        }
    }
//
//    @Override
//    public CompanyDTO activateCompany(Long companyId) {
//
//        return null;
//    }
//
//    @Override
//    public CompanyDTO deactivateCompany(Long companyId) {
//        return null;
//    }

}