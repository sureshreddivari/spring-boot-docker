package com.docker.DockerTest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Repository
public interface DockerTestRepository extends JpaRepository<Product, Long>{
    @RestResource(exported = false)
    @Query(value = "SELECT * FROM product WHERE name = ?1", nativeQuery = true)
    List<Product> findProductsByName(String name);
}
