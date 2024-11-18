package com.productmanagement.service;

import com.productmanagement.entity.Product;
import com.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Long id, Product product){
        
        Product newProduct = productRepository.findById(id).orElse(null);
        
        if(newProduct != null){
            newProduct.setName(product.getName());
            newProduct.setDescription(product.getDescription());
            newProduct.setPrice(product.getPrice());
            newProduct.setQuantity(product.getQuantity());
            productRepository.save(newProduct);
        } else {
            PrintWriter pw = new PrintWriter(System.out);
            pw.println("Invalid Id");
        }

    }
    
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

}
