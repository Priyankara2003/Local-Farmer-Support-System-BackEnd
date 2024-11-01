package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Seller;
import edu.icet.entity.SellerEntity;
import edu.icet.repository.SellerDao;
import edu.icet.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {

    final ObjectMapper objectMapper;
    final SellerDao sellerDao;

    @Override
    public String addSeller(Seller seller) {
        SellerEntity sellerEntity = objectMapper.convertValue(seller, SellerEntity.class);
        if (!sellerDao.existsByEmail(seller.getEmail())) {
            sellerDao.save(sellerEntity);
            return "Successfully registered!";
        }
        return "Email is Already Registered ! Please Try Another Email";
    }

    @Override
    public Integer getBuyer(String email, String password) {
        return objectMapper.convertValue(sellerDao.getIdOfSeller(email, password),Integer.class);
    }
}
