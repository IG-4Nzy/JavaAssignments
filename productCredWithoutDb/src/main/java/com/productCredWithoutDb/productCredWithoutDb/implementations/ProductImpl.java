package com.productCredWithoutDb.productCredWithoutDb.implementations;

import com.productCredWithoutDb.productCredWithoutDb.dto.ProductDto;
import com.productCredWithoutDb.productCredWithoutDb.model.ProductModel;
import com.productCredWithoutDb.productCredWithoutDb.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductImpl implements ProductService {

    private final List<ProductModel> productList = new ArrayList<>();
    private final AtomicInteger uniqueId = new AtomicInteger(1);

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ProductModel product = new ProductModel();
        product.setId(String.valueOf(uniqueId.getAndIncrement()));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productList.add(product);

        productDto.setId(product.getId());
        return productDto;
    }

    @Override
    public ProductDto updateProduct(String id, ProductDto productDto) {
        for(ProductModel p : productList){
            if(p.getId().equals(id)){
                p.setName(productDto.getName());
                p.setPrice(productDto.getPrice());

                return productDto;
            }
        }
        return null;
    }

    @Override
    public boolean deleteProduct(String id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<ProductDto> getProductList() {
        List<ProductDto> products = new ArrayList<>();
        for(ProductModel p : productList){
            ProductDto dto = new ProductDto();
            dto.setId(p.getId());
            dto.setName(p.getName());
            dto.setPrice(p.getPrice());
            products.add(dto);
        }
        return products;
    }

    @Override
    public List<ProductDto> getFilteredList(double minPrice) {
        List<ProductDto> products = new ArrayList<>();
        for(ProductModel p : productList){
            ProductDto dto = new ProductDto();
            dto.setId(p.getId());
            dto.setName(p.getName());
            dto.setPrice(p.getPrice());
            products.add(dto);
        }
        return products
                .stream()
                .filter(p -> p.getPrice() >= minPrice)
                .toList();
    }
}
