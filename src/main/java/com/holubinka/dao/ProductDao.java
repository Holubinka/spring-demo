package com.holubinka.dao;

import com.holubinka.model.Product;

public interface ProductDao {
    Product getById(Long id);

    Product save(Product product);
}
