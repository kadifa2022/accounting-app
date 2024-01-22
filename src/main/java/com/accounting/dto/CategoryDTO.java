package com.accounting.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CategoryDTO {

    private Long id;
    private String description;
    private CompanyDTO company;
    private boolean hasProduct;

}
