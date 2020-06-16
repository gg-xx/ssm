package com.xcu.ssm.controller;

import com.xcu.ssm.domain.Product;
import com.xcu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
    //商品修改
    @RequestMapping("/alterProduct.do")
    public String alter(Product product) throws Exception {
        productService.alterProduct(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }
    //删除全部产品
    @RequestMapping("/deleteProduct.do")
    //@RolesAllowed("ADMIN")//
    public String deleteProduct(@RequestParam(name="id",required = true)String productId) throws Exception {
        productService.deleteProductById(productId);
        return "redirect:findAll.do";
    }
    //商品详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String productId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("product",product);
        mv.setViewName("product-show");
        return mv;
    }

    //携带参数到修改页面
    @RequestMapping("/mid.do")
    public ModelAndView mid(@RequestParam(name = "id", required = true) String productId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("product",product);
        mv.setViewName("product-edit");
        return mv;
    }

}
