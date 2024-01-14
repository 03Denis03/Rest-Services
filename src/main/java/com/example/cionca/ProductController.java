package com.example.cionca;
import java.util.List;

import com.example.cionca.Product;
import com.example.cionca.ProductNotFoundException;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
public class ProductController {
    private final ProductRepository repository;

    ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    List<Product> all(){
        return repository.findAll();
    }

    @PostMapping("/users")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @GetMapping("/user/{id}")
    Product one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newProduct.getName());
                    user.setCode(newProduct.getCode());
                    user.setDescription(newProduct.getDescription());
                    user.setQuantity(newProduct.getQuantity());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }
    @DeleteMapping("/users/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
