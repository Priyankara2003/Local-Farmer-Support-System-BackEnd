package edu.icet.controller.buyer;

import edu.icet.dto.Buyer;
import edu.icet.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/buyer")
public class BuyerController {

    final BuyerService buyerService;

    @PostMapping("/register")
    public ResponseEntity<String> addBuyer(@RequestBody Buyer buyer){
        String s = buyerService.addBuyer(buyer);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @PostMapping("/login")
    public ResponseEntity<Buyer> getBuyer(@RequestPart("email")String email,@RequestPart("password")String password){
        Buyer buyer = buyerService.getBuyer(email, password);
        if (buyer==null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(buyer);
    }
}
