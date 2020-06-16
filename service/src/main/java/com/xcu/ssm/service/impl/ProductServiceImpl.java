package com.xcu.ssm.service.impl;

import com.xcu.ssm.dao.IProductDao;
import com.xcu.ssm.domain.Product;
import com.xcu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDao productDao;

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> findAll() throws Exception{
        return productDao.findAll();
    }

    @Override
    public void deleteProductById(String productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    public Product findById(String productId) throws Exception {
        return productDao.findById(productId);
    }

    @Override
    public void alterProduct(Product product) {
        productDao.alterProduct(product);
    }

}
