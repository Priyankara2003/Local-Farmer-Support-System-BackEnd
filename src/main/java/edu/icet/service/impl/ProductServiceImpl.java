package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Product;
import edu.icet.entity.ProductEntity;
import edu.icet.repository.ProductDao;
import edu.icet.service.ProductService;
import edu.icet.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    final ProductDao productDao;
    final ObjectMapper mapper;

    @Override
    public void addProduct(MultipartFile file, Product product) {
        ProductEntity productEntity = mapper.convertValue(product, ProductEntity.class);
        try {
            productEntity.setImgData(ImageUtils.compressImage(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productDao.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> all = productDao.findAll();
        for(ProductEntity productEntity: all){
            productEntity.setImgData(ImageUtils.decompressImage(productEntity.getImgData()));
        }
        return all;
    }

    @Override
    public List<ProductEntity> getSellerItems(Integer id) {
        List<ProductEntity> sellerItems = productDao.getSellerItems(id);
        for(ProductEntity productEntity: sellerItems){
            productEntity.setImgData(ImageUtils.decompressImage(productEntity.getImgData()));
        }
        return sellerItems;
    }

    @Override
    public void updateInfo(MultipartFile file, ProductEntity product) {
//        ProductEntity productEntity = mapper.convertValue(product, ProductEntity.class);
        try {
            System.out.println(Arrays.toString(file.getBytes()));
            if(file.getBytes().length != 0){
                product.setImgData(ImageUtils.compressImage(file.getBytes()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productDao.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.deleteById(id);
    }
}
