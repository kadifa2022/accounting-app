package com.accounting.service;


import com.accounting.dto.CategoryDTO;

import java.util.List;


public interface CategoryService {


    List<CategoryDTO> readAllCategories();

    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO findById(Long id);
}
