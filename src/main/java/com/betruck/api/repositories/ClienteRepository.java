package com.betruck.api.repositories;

import com.betruck.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Product, Long> {

}
