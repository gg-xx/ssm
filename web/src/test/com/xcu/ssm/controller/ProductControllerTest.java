package com.xcu.ssm.controller;

import com.xcu.ssm.domain.Product;
import com.xcu.ssm.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class ProductControllerTest {

    @Autowired
    private IProductService productService;

    @Test
    public void findAll() throws Exception {
        List<Product> list = productService.findAll();
        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void deleteProduct() {
        productService.deleteProductById("1005");
    }

    @Test
    public void alter() {
        Product p = new Product();
        p.setId("1008");
        p.setProductNum("10086");
        System.out.println(p);
        p.setProductName("修改123123");
        productService.alterProduct(p);
        System.out.println(p);
    }
}