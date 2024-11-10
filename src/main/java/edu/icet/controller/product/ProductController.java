package edu.icet.controller.product;

import edu.icet.dto.Product;
import edu.icet.entity.ProductEntity;
import edu.icet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;

    @PostMapping(value = "/add-product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addProduct(@RequestPart("file") MultipartFile file, @RequestPart("product") Product product){
        productService.addProduct(file,product);

        return new ResponseEntity<>("File uploaded successfully with student details", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public Object getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get-seller-products/{id}")
    public List<ProductEntity> getSellerItems(@PathVariable Integer id){
        return productService.getSellerItems(id);
    }

    @PostMapping("/update-info")
    public ResponseEntity<String> updateProduct(@RequestPart("file") MultipartFile file, @RequestPart("product") ProductEntity product){
        productService.updateInfo(file,product);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}
