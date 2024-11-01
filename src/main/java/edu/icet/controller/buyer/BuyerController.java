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

    @GetMapping("/login")
    public ResponseEntity<Integer> getBuyer(@RequestPart("email")String email,@RequestPart("password")String password){
        Integer buyerId = buyerService.getBuyer(email, password);
        if (buyerId==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
        }
        return ResponseEntity.status(HttpStatus.OK).body(buyerId);
    }
}
