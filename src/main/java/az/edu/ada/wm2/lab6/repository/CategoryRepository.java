package az.edu.ada.wm2.lab6.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.edu.ada.wm2.lab6.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
