package vn.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.example.demo1.entity.ProductEntity;
import vn.example.demo1.entity.UserEntity;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

      ProductEntity findFirstByName(String name);

}
