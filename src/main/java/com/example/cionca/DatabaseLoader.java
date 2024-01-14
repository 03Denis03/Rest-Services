package com.example.cionca;

import org.springframework.boot.CommandLineRunner;

public class DatabaseLoader implements CommandLineRunner {
    private final ProductRepository repository;

    public DatabaseLoader(ProductRepository repository){
        this.repository = repository;
    }

    public void run(String... strings) throws Exception{
        this.repository.save(new Product("milk", "103", "cow milk", 200));
        this.repository.save(new Product("bread", "503", "Oats flour", 20));
    }
}
