package com.productCredWithoutDb.productCredWithoutDb.service;

import com.productCredWithoutDb.productCredWithoutDb.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(String id,ProductDto productDto);
    public boolean deleteProduct(String id);
    public List<ProductDto> getProductList();
    public List<ProductDto> getFilteredList(double minPrice);
}
