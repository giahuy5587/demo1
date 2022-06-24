package vn.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.example.demo1.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity,Long> {
}
