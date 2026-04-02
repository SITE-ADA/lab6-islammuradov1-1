package az.edu.ada.wm2.lab6.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.edu.ada.wm2.lab6.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByExpirationDateBefore(LocalDate expirationDate);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
