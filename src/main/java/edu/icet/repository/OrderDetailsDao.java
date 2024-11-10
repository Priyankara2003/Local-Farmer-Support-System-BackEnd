package edu.icet.repository;

import edu.icet.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity,Integer> {
}
