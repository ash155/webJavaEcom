package com.ash.Ecom.repository;

import com.ash.Ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword, '%')) OR " +
            "LOWER(p.description) LIKE (CONCAT('%',:keyword, '%')) OR " +
            "LOWER(p.brand) LIKE (CONCAT('%',:keyword, '%')) OR " +
            "LOWER(p.category) LIKE (CONCAT('%',:keyword, '%')) ")
    List<Product> searchProducts(String keyword);

}
