package edu.icet.repository;

import edu.icet.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<ProductEntity,Integer> {
    @Query(nativeQuery = true,value = "Select * from product_details where seller_id=:id")
    List<ProductEntity> getSellerItems(@Param("id")Integer id);

}
