package com.holubinka.service;

import com.holubinka.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(Long id);

    Category reduceCategoryPriceByPercents(Category category, int percents);
}
