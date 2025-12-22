package com.epam.training.products;

import com.epam.training.products.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ProductsReader {
    private final File file;

    public ProductsReader(File file) {
        this.file = file;
    }

    public List<Product> read() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Product[] products = objectMapper.readValue(file,Product[].class);
            return Arrays.asList(products);
        }catch (Exception e){
            throw new RuntimeException("Error reading the Json: " + e.getMessage());
        }
    }
}
