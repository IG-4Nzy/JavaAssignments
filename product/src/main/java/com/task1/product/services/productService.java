package com.task1.product.services;

import com.task1.product.model.Product;
import com.task1.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class productService {

    private final ProductRepository productRepository;

    public productService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public java.util.List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public java.util.Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(String id, Product updated) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setPrice(updated.getPrice());
                    existing.setQuantity(updated.getQuantity());
                    return productRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
