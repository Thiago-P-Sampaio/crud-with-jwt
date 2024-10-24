package com.example.login_auth_rest_api_test2.Repository;

import com.example.login_auth_rest_api_test2.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository <Product, UUID> {
}
