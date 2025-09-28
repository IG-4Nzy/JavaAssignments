package com.productCredWithoutDb.productCredWithoutDb.controller;

import com.productCredWithoutDb.productCredWithoutDb.dto.ProductDto;
import com.productCredWithoutDb.productCredWithoutDb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto response = service.createProduct(productDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestParam String id,
                                                    @RequestBody ProductDto productDto){
        ProductDto response = service.updateProduct(id,productDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        boolean deleted = service.deleteProduct(id);
        String message = deleted ? "Deleted" : "No Product with this id";
        HttpStatus status = deleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(message,status);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductList(){
        List<ProductDto> products = service.getProductList();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("filtered")
    public ResponseEntity<List<ProductDto>> getFilteredProductList(@RequestParam Double minPrice){
        List<ProductDto> products = service.getFilteredList(minPrice);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
