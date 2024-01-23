package com.accounting.converter;

import com.accounting.dto.CategoryDTO;
import com.accounting.service.CategoryService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOConverter implements Converter<String, CategoryDTO> {

    private final CategoryService categoryService;

    public CategoryDTOConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDTO convert(String source) {
        if (source == null || source.equals("")){
            return null;
    }
        return categoryService.findById(Long.parseLong(source));
}
}
