package com.accounting.dto;

import com.accounting.enums.ClientVendorType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientVendorDTO {

    private Long id;
    private String clientVendorName;
    private String name;
    private String website;
    private ClientVendorType clientVendorType;
    private AddressDTO address;
    private CompanyDTO company;



}
