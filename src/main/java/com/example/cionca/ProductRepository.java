package com.example.cionca;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cionca.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {

}
