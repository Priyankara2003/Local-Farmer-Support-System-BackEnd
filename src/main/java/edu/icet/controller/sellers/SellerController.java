package edu.icet.controller.sellers;

import edu.icet.dto.Buyer;
import edu.icet.dto.Seller;
import edu.icet.service.BuyerService;
import edu.icet.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

    final SellerService sellerService;

    @PostMapping("/register")
    public ResponseEntity<String> addSeller(@RequestBody Seller seller){
        String s = sellerService.addSeller(seller);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @PostMapping("/login")
    public ResponseEntity<Seller> getSeller(@RequestPart("email")String email,@RequestPart("password")String password){
        Seller seller = sellerService.getBuyer(email, password);
        if (seller==null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(seller);
    }
}
