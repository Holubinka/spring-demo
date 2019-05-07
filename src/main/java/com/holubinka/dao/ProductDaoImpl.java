package com.holubinka.dao;

import com.holubinka.model.Category;
import com.holubinka.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Product getById(Long id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Product p  where p.id=:id", Product.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Product save(Product product) {
        sessionFactory.getCurrentSession().update(product);
        return product;
    }
}
