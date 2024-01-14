
package com.example.cionca;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_entity")
public class Product {
    @Id
    private
    @GeneratedValue (strategy = GenerationType.AUTO)Long id;
    private String name;
    private String code;
    private String description;
    private int quantity;
    private Product() {}
    public Product(String name, String code, String description, int quantity) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.quantity = quantity;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(code, product.code) &&
                Objects.equals(description, product.description)&&
                Objects.equals(quantity, product.quantity);
    }

    public int hashCode() {

        return Objects.hash(id, name, code, description, quantity);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity =quantity;
    }
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

}
