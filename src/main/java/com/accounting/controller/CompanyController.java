package com.accounting.controller;

import com.accounting.dto.CompanyDTO;
import com.accounting.dto.ResponseWrapper;
import com.accounting.enums.CompanyStatus;
import com.accounting.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/list")
    public ResponseEntity<ResponseWrapper> listCompanies() {
        return ResponseEntity.ok(new ResponseWrapper("Companies are successfully retrieved",
                companyService.listAllCompaniesOrderByStatus(), HttpStatus.OK));


    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCompany(@RequestBody CompanyDTO companyDTO) {
        // companyService.save(companyDTO);
        return ResponseEntity.ok(new ResponseWrapper("Company is successfully created",
                companyService.createCompany(companyDTO), HttpStatus.OK));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseWrapper> updateCompany(@PathVariable("id") Long id, @RequestBody CompanyDTO companyDTO) {
        // companyService.save(companyDTO);
        return ResponseEntity.ok(new ResponseWrapper("Company is successfully updated",
                companyService.updateCompany(id, companyDTO), HttpStatus.OK));
    }

    @PostMapping("/activate/deactivate")
    public ResponseEntity<ResponseWrapper> activateDeactivateCompanyStatus(@RequestBody CompanyDTO companyDTO) {

        return ResponseEntity.ok(new ResponseWrapper("Company activated  successfully",
                companyService.activateDeactivateCompanyStatus(companyDTO.getId()), HttpStatus.OK));
    }




}