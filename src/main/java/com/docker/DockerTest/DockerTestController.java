package com.docker.DockerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DockerTestController {
    private static final Logger logger = LoggerFactory.getLogger(DockerTestController.class);
    @Autowired
    private DockerTestService dockerTestService;

    @GetMapping("/hi")
    public String hi() {
        logger.info("logger enabled");
        return "Hello hi my docker first application";
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        logger.info("save method invoked");
        Product response = dockerTestService.saveProduct(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        // Call the service method to retrieve the product by ID
        Product product = dockerTestService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductById(@PathVariable String name) {
        // Call the service method to retrieve the product by ID
        List<Product> products = dockerTestService.getProductsByName(name);

        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long productId) {
        // Call the service method to delete the product by ID
        boolean deleted = dockerTestService.deleteProduct(productId);

        if (deleted) {
            return ResponseEntity.ok("Product with ID " + productId + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
