package com.example.login_auth_rest_api_test2.model.product;

import com.example.login_auth_rest_api_test2.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table (name="Product")
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id @GeneratedValue (strategy = GenerationType.UUID)
    private UUID idProduct;
    private String nameProduct;
    private float priceProduct;

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Product(ProductDTO dtoInfo){
    this.nameProduct = dtoInfo.nameProduct();
    this.priceProduct = dtoInfo.priceProduct();
    }

}
