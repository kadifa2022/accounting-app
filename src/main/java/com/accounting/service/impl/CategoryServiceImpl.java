package com.accounting.service.impl;

import com.accounting.dto.CategoryDTO;

import com.accounting.entity.Category;
import com.accounting.mapper.MapperUtil;
import com.accounting.repository.CategoryRepository;
import com.accounting.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final MapperUtil mapperUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, MapperUtil mapperUtil) {
        this.categoryRepository = categoryRepository;
        this.mapperUtil = mapperUtil;
    }



    @Override
    public List<CategoryDTO> readAllCategories() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(category -> mapperUtil.convert(category, new CategoryDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category newCategory = categoryRepository.findById(categoryDTO.getId()).orElseThrow();
        Category categoryToSave = mapperUtil.convert(newCategory, new Category());
        categoryRepository.save(categoryToSave);
        return mapperUtil.convert(categoryToSave, new CategoryDTO());
    }

    @Override
    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return mapperUtil.convert(category, new CategoryDTO());




        }

    }



