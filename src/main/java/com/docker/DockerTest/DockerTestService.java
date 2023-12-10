package com.docker.DockerTest;

import com.docker.DockerTest.Product;
import com.docker.DockerTest.DockerTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DockerTestService {
    @Autowired
    private DockerTestRepository dockerTestRepository;

    /*@Autowired
    public DockerTestService(DockerTestRepository dockerTestRepository) {
        this.dockerTestRepository = dockerTestRepository;
    }*/


    public Product saveProduct(Product product) {
        return dockerTestRepository.save(product);
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = dockerTestRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    public List<Product> getProductsByName(String name) {
        return dockerTestRepository.findProductsByName(name);
    }

    public boolean deleteProduct(Long productId) {
        Optional<Product> optionalProduct = dockerTestRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            // Product found, delete it
            dockerTestRepository.deleteById(productId);
            return true; // Indicate successful deletion
        } else {
            // Product not found
            return false; // Indicate that the product was not found
        }
    }

}
