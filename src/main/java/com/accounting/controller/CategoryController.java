package com.accounting.controller;

import com.accounting.mapper.MapperUtil;
import com.accounting.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final MapperUtil mapperUtil;


    public CategoryController(CategoryService categoryService, MapperUtil mapperUtil) {
        this.categoryService = categoryService;
        this.mapperUtil = mapperUtil;
    }
}
