package com.example.login_auth_rest_api_test2.model.Controller.Product;

import com.example.login_auth_rest_api_test2.Repository.ProductRepository;
import com.example.login_auth_rest_api_test2.model.product.Product;
import com.example.login_auth_rest_api_test2.DTO.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        var get = repository.findAll();
        return ResponseEntity.ok(get);
    }

    @PostMapping
    public ResponseEntity PostProduct(@RequestBody @Valid ProductDTO data) {
        Product create = new Product(data);
        repository.save(create);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity UpdtProduct(@PathVariable("idProduct") @Valid UUID idProduct,
                                      @RequestBody @Valid ProductDTO data) {
        Optional<Product> exists = repository.findById(idProduct);
        if (exists.isPresent()) {
            Product prodct = exists.get();
            prodct.setNameProduct(data.nameProduct());
            prodct.setPriceProduct(data.priceProduct());
            repository.save(prodct);
            return  ResponseEntity.ok(prodct);
        } else return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{idProduct}")
    public ResponseEntity UpdtProduct(@PathVariable("idProduct") @Valid UUID idProduct) {
        Optional<Product>exists = repository.findById(idProduct);
        if(exists.isPresent()){
            repository.deleteById(idProduct);
            return  ResponseEntity.ok().build();
        }else return ResponseEntity.notFound().build();

    }

}
