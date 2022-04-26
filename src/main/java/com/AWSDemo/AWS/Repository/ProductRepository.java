package com.AWSDemo.AWS.Repository;

import com.AWSDemo.AWS.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

@Query(value = "Select * FROM product_inventory where productName=?1",nativeQuery = true)
    List<Product> getProductByName(String product_name);
}
