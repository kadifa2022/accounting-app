package com.accounting.entity;

import com.accounting.enums.CompanyStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    @Column(unique = true)
    private String title;

    private String phone;
    private String website;

    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address; // this needs to be ManyToOne diagram


}
