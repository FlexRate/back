package com.sbb.flexrate.controller;

import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {
    private final CreditService creditService;

    //get method 매핑
    @GetMapping("/{memberId}")
    public ResponseEntity<?> getCreditByMemberId(@PathVariable Long memberId){
        try {
            return ResponseEntity.ok(creditService.findMyCredit(memberId));
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<?> updateCredit(@PathVariable Long memberId, @RequestBody CreditCreateRequestDto creditDto){
        try {
            creditService.updateCredit(memberId,creditDto);
            return ResponseEntity.ok("Credit updated successfully.");
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
