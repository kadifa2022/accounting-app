package com.accounting.service;


import com.accounting.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO findById(Long  id);
}
