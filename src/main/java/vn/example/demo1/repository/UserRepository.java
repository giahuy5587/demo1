package vn.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.example.demo1.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findById (Long id);
    List<UserEntity> findByUserNameContaining(String name);
    List<UserEntity> findAll ();

}
