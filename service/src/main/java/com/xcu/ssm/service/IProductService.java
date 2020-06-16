package com.xcu.ssm.service;

import com.xcu.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    void deleteProductById(String productId);

    Product findById(String productId) throws Exception;

    void alterProduct(Product product);
}
