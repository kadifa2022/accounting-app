package com.accounting.controller;


import com.accounting.dto.CategoryDTO;
import com.accounting.dto.ResponseWrapper;

import com.accounting.service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;



    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }
  @GetMapping
    public ResponseEntity <ResponseWrapper> readAllCategories(){
        return ResponseEntity.ok(new ResponseWrapper("Categories are successfully retrieved",
                categoryService.readAllCategories(),HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(new ResponseWrapper("Category is successfully created"
                , categoryService.create(categoryDTO),HttpStatus.OK));

    }



}
