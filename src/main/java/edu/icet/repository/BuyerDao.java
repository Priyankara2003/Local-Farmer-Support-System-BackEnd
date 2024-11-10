package edu.icet.repository;

import edu.icet.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BuyerDao extends JpaRepository<BuyerEntity, Integer> {
    @Query(nativeQuery = true,value = "Select * from buyers where email=:email and password=:password")
    Optional<BuyerEntity> getIdOfBuyer(@Param("email")String email,@Param("password")String password);

    boolean existsByEmail(String email);
}
