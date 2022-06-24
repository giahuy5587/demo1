package vn.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.example.demo1.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
