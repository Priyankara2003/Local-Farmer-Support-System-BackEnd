package edu.icet.service;

import edu.icet.dto.Product;
import edu.icet.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void addProduct(MultipartFile file, Product product);

    List<ProductEntity> getAllProducts();

    List<ProductEntity> getSellerItems(Integer id);

    void updateInfo(MultipartFile file, ProductEntity product);

    void deleteProduct(Integer id);
}
