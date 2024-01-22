package com.accounting.entity;

import com.accounting.enums.ClientVendorType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "clients_vendors")
public class ClientVendor extends BaseEntity{

    private String phone;
    private String website;

    @OneToOne (cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @Enumerated(EnumType.STRING)
    private ClientVendorType clientVendorType;

    private String clientVendorName;

}
