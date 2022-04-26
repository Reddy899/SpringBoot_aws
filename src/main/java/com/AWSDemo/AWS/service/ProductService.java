package com.AWSDemo.AWS.service;

import com.AWSDemo.AWS.Repository.ProductRepository;
import com.AWSDemo.AWS.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;



    public Product saveproduct(Product product)
    {
       return productRepository.save(product);
    }


    public Product getProduct(long productid)
    {
        return productRepository.findById(productid).orElseThrow(()->new RuntimeException("Not Found"));
    }

    public List<Product> getproducts()
    {
        return productRepository.findAll();
    }

    public Product updateProduct(long productId,Product product)
    {
        Product existingProduct=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Not Found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public Product deleteProduct(long productId)
    {
        Product existingProduct=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Not Found"));
        productRepository.deleteById(productId);
        return existingProduct;

    }

    public List<Product> getProductByName(String product_name)
    {
        return productRepository.getProductByName(product_name);
    }

}
