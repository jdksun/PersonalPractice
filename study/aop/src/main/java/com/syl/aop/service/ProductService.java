package com.syl.aop.service;

import com.syl.aop.pojo.Product;

//@Service()
public class ProductService {

    public void insert(Product product){
        System.out.println("insert product");
    }
    public void delete(Long id){
        System.out.println("delete product");
    }
}
