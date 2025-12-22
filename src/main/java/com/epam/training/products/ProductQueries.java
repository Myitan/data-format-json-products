package com.epam.training.products;

import com.epam.training.products.domain.Product;

import java.util.*;

public class ProductQueries {
    private final List<Product> products;
    public ProductQueries(List<Product> products) {
        this.products = products;
    }

    public List<String> getSubCategoriesOf(String categoryName) {
        Set<String> subCategories = new HashSet<>();
        for (Product product : products){
            if (product.hasSubCategory() && categoryName.equals(product.getCategory())){
                subCategories.add(product.getSubCategory());
            }
        }
        return new ArrayList<>(subCategories);
    }

    public List<Product> getSweetsWherePriceIsLowerThan(double price) {
        List<Product> sweets = new ArrayList<>();
        for (Product product : products){
            if (product.hasCategory() && "sweets".equals(product.getCategory()) && product.getPrice() < price){
                sweets.add(product);
            }
        }
        return sweets;
    }

    public Product getTheMostExpensiveProduct() {
        if (products.isEmpty()){
            return null;
        }
        Product mostExpensiveProduct = products.get(0);
        for (Product product : products){
            if (product.getPrice() > mostExpensiveProduct.getPrice()){
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }
}
