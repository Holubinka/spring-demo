package com.holubinka.service;

import com.holubinka.dao.ProductDao;
import com.holubinka.model.Category;
import com.holubinka.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product reducePriceByPercents(Product product, int percents) {
        double newPrice = product.getPrice() - (product.getPrice() * (percents / 100.0));
        product.setPrice(newPrice);
        return productDao.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

}
