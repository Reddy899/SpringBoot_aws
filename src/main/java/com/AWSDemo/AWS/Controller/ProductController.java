package com.AWSDemo.AWS.Controller;

import com.AWSDemo.AWS.model.Product;
import com.AWSDemo.AWS.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//insert into Database
    @PostMapping("/product")
    public ResponseEntity<Product> saveproduct(@RequestBody Product product) {
        Product saved = productService.saveproduct(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


// Get a product by its ID
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name="productid") long productid)
    {
        Product product=productService.getProduct(productid);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }
// Get all Product in Database

    @GetMapping("/products")
  public List<Product> GetProducts()
  {
     return  productService.getproducts();

  }
// Update existing product in Database

   @PatchMapping("/product")
   public ResponseEntity<Product> updateProduct(@RequestParam(name="productId") long productId,Product product)
   {
       Product updateProduct=productService.updateProduct(productId,product);
       return new ResponseEntity<>(updateProduct,HttpStatus.OK);
   }

//Delete an existing product in Database
    @DeleteMapping
    public ResponseEntity<Product> deleteProduct(@RequestParam(name="productId") long productId)
    {
        Product deleteProduct=productService.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct,HttpStatus.OK);

    }

// Get product by name using raw SQL
  public List<Product> getProductByName(@RequestParam(name="product_name") String product_name)
   {

    return productService.getProductByName(product_name);

}




}
