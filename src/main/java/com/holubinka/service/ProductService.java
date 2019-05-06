package com.holubinka.service;

import com.holubinka.model.Product;

public interface ProductService {
    Product reducePriceByPercents(Product product, int percents);

}
