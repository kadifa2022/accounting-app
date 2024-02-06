package com.accounting.repository;


import com.accounting.dto.CategoryDTO;
import com.accounting.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    CategoryDTO findById(CategoryDTO categoryDTO);
}
