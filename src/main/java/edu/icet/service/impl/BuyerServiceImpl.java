package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Buyer;
import edu.icet.entity.BuyerEntity;
import edu.icet.repository.BuyerDao;
import edu.icet.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    final BuyerDao buyerDao;
    final ObjectMapper objectMapper;

    @Override
    public String addBuyer(Buyer buyer) {
        BuyerEntity buyerEntity = objectMapper.convertValue(buyer, BuyerEntity.class);
        if (!buyerDao.existsByEmail(buyer.getEmail())) {
            buyerDao.save(buyerEntity);
            return "Successfully registered!";
        }
        return "Email is Already Registered ! Please Try Another Email";
    }

    @Override
    public Buyer getBuyer(String email, String password) {
        return objectMapper.convertValue(buyerDao.getIdOfBuyer(email, password),Buyer.class);
    }
}
