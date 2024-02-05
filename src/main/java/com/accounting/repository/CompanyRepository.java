package com.accounting.repository;

import com.accounting.entity.Company;
import com.accounting.enums.CompanyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAllOrderByCompanyStatus(CompanyStatus status);


}
