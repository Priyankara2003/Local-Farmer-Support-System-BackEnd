package edu.icet.repository;

import edu.icet.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SellerDao extends JpaRepository<SellerEntity,Integer> {
    @Query(nativeQuery = true,value = "Select seller_id from sellers where email=:email and password=:password")
    Optional<Integer> getIdOfSeller(@Param("email")String email, @Param("password")String password);

    boolean existsByEmail(String email);
}
